package com.sbrf.reboot.concurrent;

import com.sbrf.reboot.dto.Account;
import com.sbrf.reboot.dto.Customer;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static java.time.Month.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MainReportTest {

    Set<Customer> customers;
    BigDecimal total;

    @BeforeEach
    void setUp() {
        Set<Account> accountsCustomer1 = new HashSet<Account>() {{
            add(Account.builder()
                    .accountNumber("ACC1234NUM")
                    .createDate(LocalDate.of(2021, AUGUST, 10))
                    .balance(BigDecimal.valueOf(1000))
                    .currency("RUB")
                    .build());
        }};

        Set<Account> accountsCustomer2 = new HashSet<Account>() {{
            add(Account.builder()
                    .accountNumber("ACC12NUM")
                    .createDate(LocalDate.of(2021, APRIL, 5))
                    .balance(BigDecimal.valueOf(1000))
                    .currency("RUB")
                    .build());
            add(Account.builder()
                    .accountNumber("ACC34NUM")
                    .createDate(LocalDate.of(2021, JULY, 23))
                    .balance(BigDecimal.valueOf(1000))
                    .currency("USD")
                    .build());
            add(Account.builder()
                    .accountNumber("ACC567NUM")
                    .createDate(LocalDate.of(2021, JULY, 29))
                    .balance(BigDecimal.valueOf(1000))
                    .currency("RUB")
                    .build());
        }};

        Set<Account> accountsCustomer3 = new HashSet<Account>() {{
            add(Account.builder()
                    .accountNumber("ACC9087NUM")
                    .createDate(LocalDate.of(2021, JULY, 8))
                    .balance(BigDecimal.valueOf(1000))
                    .currency("RUB")
                    .build());
        }};

        Set<Account> accountsCustomer4 = new HashSet<Account>() {{
            add(Account.builder()
                    .accountNumber("ACC8756NUM")
                    .createDate(LocalDate.of(2021, AUGUST, 4))
                    .balance(BigDecimal.valueOf(1000))
                    .currency("RUB")
                    .build());
            add(Account.builder()
                    .accountNumber("ACC9999NUM")
                    .createDate(LocalDate.of(2021, JULY, 4))
                    .balance(BigDecimal.valueOf(1000))
                    .currency("RUB")
                    .build());
            add(Account.builder()
                    .accountNumber("ACC1000NUM")
                    .createDate(LocalDate.of(2021, JULY, 5))
                    .balance(BigDecimal.valueOf(1000))
                    .currency("RUB")
                    .build());
        }};

        Set<Account> accountsCustomer5 = new HashSet<Account>() {{
            add(Account.builder()
                    .accountNumber("ACC4366NUM")
                    .createDate(LocalDate.of(2021, JULY, 14))
                    .balance(BigDecimal.valueOf(1000))
                    .currency("EUR")
                    .build());
            add(Account.builder()
                    .accountNumber("ACC8097NUM")
                    .createDate(LocalDate.of(2021, JULY, 15))
                    .balance(BigDecimal.valueOf(1000))
                    .currency("RUB")
                    .build());
            add(Account.builder()
                    .accountNumber("ACC2100NUM")
                    .createDate(LocalDate.of(2021, JULY, 25))
                    .balance(BigDecimal.valueOf(1000))
                    .currency("RUB")
                    .build());
        }};

        Set<Account> accountsCustomer6 = new HashSet<Account>() {{
            add(Account.builder()
                    .accountNumber("ACC0000NUM")
                    .createDate(LocalDate.of(2019, JUNE, 1))
                    .balance(BigDecimal.valueOf(1000))
                    .currency("USD")
                    .build());
        }};

        customers = new HashSet<Customer>() {{
            add(Customer.builder().name("Alex").age(21).accounts(accountsCustomer1).build());
            add(Customer.builder().name("Jake").age(26).accounts(accountsCustomer2).build());
            add(Customer.builder().name("Bob").age(29).accounts(accountsCustomer3).build());
            add(Customer.builder().name("Alice").age(32).accounts(accountsCustomer4).build());
            add(Customer.builder().name("Kate").age(24).accounts(accountsCustomer5).build());
            add(Customer.builder().name("Henry").age(16).accounts(accountsCustomer6).build());
        }};
        total = BigDecimal.valueOf(4000);
    }

    @SneakyThrows
    @Test
    void getTotalsWithStream() {
        assertEquals(total, MainReport.getTotalsWithStream(customers.stream()));
    }

    @SneakyThrows
    @Test
    void getTotalsWithCompletableFuture() {
        assertEquals(total, MainReport.getTotalsWithCompletableFuture(customers.stream()));
    }

    @SneakyThrows
    @Test
    void getTotalsWithReact() {
        assertEquals(total, MainReport.getTotalsWithReact(customers.stream()));
    }
}