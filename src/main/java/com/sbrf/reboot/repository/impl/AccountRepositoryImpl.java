package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.repository.AccountRepository;
import com.sbrf.reboot.repository.entity.Account;
import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.Set;

@AllArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

    private Map<Long, Set<Account>> accounts;

    @Override
    public Set<Account> getAllAccountsByClientId(long id) {
        return accounts.get(id);
    }
}
