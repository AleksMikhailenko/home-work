package com.sbrf.reboot.service;

import com.sbrf.reboot.dto.Account;
import com.sbrf.reboot.repository.AccountRepository;
import com.sbrf.reboot.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@DisplayName("Unit-level testing for AccountService")
class AccountServiceTest {

    @Mock
    AccountRepository accountRepository;

    AccountService accountService;

    @BeforeEach
    void setUp() {
        accountRepository = Mockito.mock(AccountRepository.class);

        accountService = new AccountServiceImpl(accountRepository);
    }

    @Test
    void bookExist() throws IOException {
        // given
        Account account = Account.builder().id(1L).accountNumber("ACC1234NUM").build();
        Set<Account> accounts = new HashSet<>();
        accounts.add(account);

        // when
        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        // then
        assertTrue(accountService.isAccountExist(1L, account));
    }

    @Test
    void bookNotExist() throws IOException {
        // given
        Set<Account> accounts = new HashSet<Account>() {{
            add(Account.builder().id(1L).accountNumber("ACC1234NUM").build());
        }};

        // when
        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        // then
        assertFalse(accountService.isAccountExist(1L, Account.builder().id(1L).accountNumber("ACC456NUM").build()));
    }
}