package com.sbrf.reboot.service.impl;

import com.sbrf.reboot.repository.AccountRepository;
import com.sbrf.reboot.repository.entity.Account;
import com.sbrf.reboot.service.AccountService;
import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Override
    public boolean isAccountExist(long id, Account account) {
        Set<Account> clientAccounts = accountRepository.getAllAccountsByClientId(id);
        return clientAccounts.contains(account);
    }
}