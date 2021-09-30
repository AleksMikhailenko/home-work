package com.sbrf.reboot.concurrent;

import com.sbrf.reboot.dto.Account;
import com.sbrf.reboot.dto.Customer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.Month.AUGUST;
import static java.time.Month.JULY;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MainReport {

    private static final LocalDate START_DATE = LocalDate.of(2021, JULY, 1);
    private static final LocalDate END_DATE = LocalDate.of(2021, AUGUST, 1);
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 30;
    private static final String CURRENCY = "RUB";

    public static BigDecimal getTotalsWithStream(Stream<Customer> customers) {
        return customers
                .filter(customer -> customer.getAge() > MIN_AGE
                        && customer.getAge() < MAX_AGE)
                .flatMap(customer -> customer.getAccounts().stream())
                .filter(account -> CURRENCY.equals(account.getCurrency()))
                .filter(account -> account.getCreateDate().isAfter(START_DATE)
                        && account.getCreateDate().isBefore(END_DATE))
                .map(Account::getBalance)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public static BigDecimal getTotalsWithCompletableFuture(Stream<Customer> customers)
            throws ExecutionException, InterruptedException {

        List<CompletableFuture<BigDecimal>> tasks = customers
                .filter(customer -> customer.getAge() > MIN_AGE
                        && customer.getAge() < MAX_AGE)
                .map(Customer::getAccounts)
                .map(accounts -> getTotalsForClient(accounts.stream()))
                .collect(Collectors.toList());

        CompletableFuture<BigDecimal> result = CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0]))
                .thenApply(
                        v -> tasks.stream()
                                .map(CompletableFuture::join)
                                .reduce(BigDecimal::add)
                                .orElse(BigDecimal.ZERO)
                );

        return result.get();
    }

    private static CompletableFuture<BigDecimal> getTotalsForClient(Stream<Account> accounts) {
        return CompletableFuture.supplyAsync(
                () -> accounts
                        .filter(account -> CURRENCY.equals(account.getCurrency()))
                        .filter(account -> account.getCreateDate().isAfter(START_DATE)
                                && account.getCreateDate().isBefore(END_DATE))
                        .map(Account::getBalance)
                        .reduce(BigDecimal::add)
                        .orElse(BigDecimal.ZERO)
        );
    }

    public static BigDecimal getTotalsWithReact(Stream<Customer> customers)
            throws InterruptedException, ExecutionException {
        // Schedulers.parallel() количество ядер ЦП
        return Flux.fromStream(customers)
                .filter(customer -> customer.getAge() > MIN_AGE
                        && customer.getAge() < MAX_AGE)
                .parallel()
                .runOn(Schedulers.parallel())
                .flatMap(customer -> Flux.fromStream(customer.getAccounts().stream()))
                .filter(account -> CURRENCY.equals(account.getCurrency()))
                .filter(account -> account.getCreateDate().isAfter(START_DATE)
                        && account.getCreateDate().isBefore(END_DATE))
                .map(Account::getBalance)
                .log(Thread.currentThread().getName())
                .sequential()
                .reduce(BigDecimal::add)
                .toFuture()
                .get();
    }
}
