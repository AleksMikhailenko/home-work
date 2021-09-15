package com.sbrf.reboot.service;

import com.sbrf.reboot.dto.Account;
import com.sbrf.reboot.repository.AccountRepository;
import lombok.SneakyThrows;
import com.sbrf.reboot.dto.Account;
import com.sbrf.reboot.repository.AccountRepository;
import com.sbrf.reboot.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
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

    @SneakyThrows
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

    @SneakyThrows
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

    @SneakyThrows
    @Test
    void getMaxAccountBalance() {
        Account accountWithMaxBalance = Account.builder().clientId(1L).id(4L).balance(new BigDecimal(150000)).build();
        Set<Account> accounts = new HashSet() {{
            add(Account.builder().clientId(1L).id(1L).balance(BigDecimal.TEN).build());
            add(Account.builder().clientId(1L).id(2L).balance(new BigDecimal(200)).build());
            add(Account.builder().clientId(1L).id(3L).balance(new BigDecimal("1.65")).build());
            add(accountWithMaxBalance);
        }};

        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        assertEquals(accountWithMaxBalance, accountService.getMaxAccountBalance(1L));
    }


    @SneakyThrows
    @Test
    void getAllAccountsByDateMoreThen() {
        Account account1 = Account.builder().clientId(1L)
                .createDate(LocalDate.now().minusDays(2))
                .build();
        Account account2 = Account.builder().clientId(1L)
                .createDate(LocalDate.now().minusDays(3))
                .build();
        Account account3 = Account.builder().clientId(1L)
                .createDate(LocalDate.now().minusDays(1))
                .build();
        Account account4 = Account.builder().clientId(1L)
                .createDate(LocalDate.now().minusDays(7))
                .build();

        Set<Account> accounts = new HashSet() {{
            add(account1);
            add(account2);
            add(account3);
            add(account4);
        }};

        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        Set allAccountsByDateMoreThen = accountService.getAllAccountsByDateMoreThen(1L, LocalDate.now().minusDays(2));

        assertEquals(2, allAccountsByDateMoreThen.size());
        assertTrue(allAccountsByDateMoreThen.contains(account3));
    }

}