package com.sbrf.reboot.service.impl;

import com.sbrf.reboot.dto.Account;
import com.sbrf.reboot.repository.AccountRepository;
import com.sbrf.reboot.service.AccountService;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.Set;

@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Override
    public boolean isAccountExist(long id, Account account) throws IOException {
        Set<Account> clientAccounts = accountRepository.getAllAccountsByClientId(id);
        return clientAccounts.contains(account);
    }
}