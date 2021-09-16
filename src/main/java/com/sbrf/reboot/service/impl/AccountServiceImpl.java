package com.sbrf.reboot.service.impl;

import com.sbrf.reboot.dto.Account;
import com.sbrf.reboot.repository.AccountRepository;
import com.sbrf.reboot.service.AccountService;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Override
    public boolean isAccountExist(long id, Account account) throws IOException {
        Set<Account> clientAccounts = accountRepository.getAllAccountsByClientId(id);
        return clientAccounts.contains(account);
    }

    @Override
    public Optional<Account> getMaxAccountBalance(long id) throws IOException {
        Set<Account> clientAccounts = accountRepository.getAllAccountsByClientId(id);
        return clientAccounts.stream()
                .max(Comparator.comparing(Account::getBalance));
    }

    @Override
    public Set<Account> getAllAccountsByDateMoreThen(long id, LocalDate date) throws IOException {
        Set<Account> clientAccounts = accountRepository.getAllAccountsByClientId(id);
        return clientAccounts.stream()
                .filter(account -> account.getCreateDate().compareTo(date) >= 0)
                .collect(Collectors.toSet());
    }

    @Override
    public BigDecimal getSumBalanceForAllClientAccounts(long id) throws IOException {
        Set<Account> clientAccounts = accountRepository.getAllAccountsByClientId(id);
        return clientAccounts.stream()
                .map(Account::getBalance)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}