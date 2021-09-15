package com.sbrf.reboot.repository;

import com.sbrf.reboot.dto.Account;
import com.sbrf.reboot.repository.impl.AccountRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit-level testing for AccountRepository")
class AccountRepositoryTest {

    private AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        accountRepository = new AccountRepositoryImpl("src/main/resources/Accounts.txt");
    }

    @Test
    void shouldProperlyGetAccountsById() throws IOException {
        // when
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(1L);

        // then
        assertEquals(3, allAccountsByClientId.size());
    }

    @Test
    void shouldDefineWhenClientAccountExist() throws IOException {
        // given
        Account account = Account.builder().id(1L).accountNumber("1-ACCNUM").build();

        // when
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(1L);

        // then
        assertTrue(allAccountsByClientId.contains(account));
    }

    @Test
    void shouldDefineWhenClientAccountDoesNotExist() throws IOException {
        // given
        Account account = Account.builder().id(1L).accountNumber("3-ACCNUM").build();

        // when
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(1L);

        // then
        assertFalse(allAccountsByClientId.contains(account));
    }
}