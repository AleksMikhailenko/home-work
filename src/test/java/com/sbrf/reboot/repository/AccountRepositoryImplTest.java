package com.sbrf.reboot.repository;

import com.sbrf.reboot.dto.Account;
import com.sbrf.reboot.repository.impl.AccountRepositoryImpl;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountRepositoryImplTest {

    AccountRepository accountRepository;

    @SneakyThrows
    @Test
    void onlyPersonalAccounts() {
        accountRepository = new AccountRepositoryImpl("src/test/resources/Accounts.txt");
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(1L);
        ArrayList<Account> accounts = new ArrayList<Account>() {{
            add(Account.builder().id(1L).accountNumber("2-ACCNUM").build());
            add(Account.builder().id(1L).accountNumber("1-ACCNUM").build());
            add(Account.builder().id(1L).accountNumber("4-ACC1NUM").build());
        }};

        assertTrue(accounts.containsAll(allAccountsByClientId));
    }

    @SneakyThrows
    @Test
    void successGetAllAccountsByClientId() {
        accountRepository = new AccountRepositoryImpl("src/test/resources/Accounts.txt");
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(1L);
        assertTrue(allAccountsByClientId.contains(Account.builder().id(1L).accountNumber("4-ACC1NUM").build()));
    }

    @Test
    void failGetAllAccountsByClientId() {
        accountRepository = new AccountRepositoryImpl("somePath");
        assertThrows(FileNotFoundException.class,
                () -> accountRepository.getAllAccountsByClientId(1L));
    }

    @SneakyThrows
    @Test
    void successUpdateAccountNumberByClientId() {
        accountRepository = new AccountRepositoryImpl("src/test/resources/UpdatedAccounts.txt");
        accountRepository.updateAccountNumberByClientId(1L, "2-ACCNUM", "99-ACCNUM");
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(1L);
        assertTrue(allAccountsByClientId.contains(Account.builder().id(1L).accountNumber("99-ACCNUM").build()));
    }

    @Test
    void failUpdateAccountNumberByClientId() {
        accountRepository = new AccountRepositoryImpl("somePath");
        assertThrows(FileNotFoundException.class,
                () -> accountRepository.updateAccountNumberByClientId(1L, "2-ACCNUM", "99-ACCNUM"));
    }
}