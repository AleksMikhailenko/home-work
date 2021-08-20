package com.sbrf.reboot.repository;

import com.sbrf.reboot.repository.entity.Account;
import com.sbrf.reboot.repository.impl.AccountRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit-level testing for AccountRepository")
class AccountRepositoryTest {

    private AccountRepository accountRepository;

    @BeforeEach
    public void setUp() {
        Set<Account> accountsFirstClient = new HashSet<Account>() {{
            add(new Account("ACC1234NUM"));
            add(new Account("ACC4567NUM"));
        }};

        Map<Long, Set<Account>> accounts = new HashMap<Long, Set<Account>>() {{
            put(1L, accountsFirstClient);
        }};

        accountRepository = new AccountRepositoryImpl(accounts);
    }

    @Test
    public void shouldProperlyGetAccountsById() {
        // when
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(1L);

        // then
        assertEquals(2, allAccountsByClientId.size());
    }

    @Test
    public void shouldDefineWhenClientAccountExist() {
        // given
        Account account = new Account("ACC4567NUM");

        // when
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(1L);

        // then
        assertTrue(allAccountsByClientId.contains(account));
    }

    @Test
    public void shouldDefineWhenClientAccountDoesNotExist() {
        // given
        Account account = new Account("ACC0989NUM");

        // when
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(1L);

        // then
        assertFalse(allAccountsByClientId.contains(account));
    }

    @Test
    public void shouldReturnNullWhenClientIdDoesNotExist() {

        assertNull(accountRepository.getAllAccountsByClientId(56L));
    }
}