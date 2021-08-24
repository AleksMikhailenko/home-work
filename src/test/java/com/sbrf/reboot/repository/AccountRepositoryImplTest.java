package com.sbrf.reboot.repository;

import com.sbrf.reboot.repository.entity.Account;
import com.sbrf.reboot.repository.impl.AccountRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountRepositoryImplTest {

    AccountRepository accountRepository;

    @Test
    void onlyPersonalAccounts() throws IOException {
        accountRepository = new AccountRepositoryImpl("src/test/resources/Accounts.txt");
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(1L);
        ArrayList<Account> accounts = new ArrayList<Account>() {{
            add(new Account(1L, "2-ACCNUM"));
            add(new Account(1L, "1-ACCNUM"));
            add(new Account(1L, "4-ACC1NUM"));
        }};

        assertTrue(accounts.containsAll(allAccountsByClientId));
    }

    @Test
    void successGetAllAccountsByClientId() throws IOException {
        accountRepository = new AccountRepositoryImpl("src/test/resources/Accounts.txt");
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(1L);
        assertTrue(allAccountsByClientId.contains(new Account(1L, "4-ACC1NUM")));
    }

    @Test
    void failGetAllAccountsByClientId() {
        accountRepository = new AccountRepositoryImpl("somePath");
        assertThrows(FileNotFoundException.class,
                () -> accountRepository.getAllAccountsByClientId(1L));
    }

    @Test
    void successUpdateAccountNumberByClientId() throws IOException {
        accountRepository = new AccountRepositoryImpl("src/test/resources/UpdatedAccounts.txt");
        accountRepository.updateAccountNumberByClientId(1L, "2-ACCNUM", "99-ACCNUM");
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(1L);
        assertTrue(allAccountsByClientId.contains(new Account(1L, "99-ACCNUM")));
    }

    @Test
    void failUpdateAccountNumberByClientId() {
        accountRepository = new AccountRepositoryImpl("somePath");
        assertThrows(FileNotFoundException.class,
                () -> accountRepository.updateAccountNumberByClientId(1L, "2-ACCNUM", "99-ACCNUM"));
    }
}