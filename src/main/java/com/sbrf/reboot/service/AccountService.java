package com.sbrf.reboot.service;

import com.sbrf.reboot.dto.Account;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

public interface AccountService {

    /**
     * Returns <i>true</i> if account exist, otherwise <i>false</i>.
     *
     * @param id      is a client's identifier
     * @param account {@link Account}'s object for searching
     * @return <i>true</i> if account exist
     */
    boolean isAccountExist(long id, Account account) throws IOException;

    /**
     * Returns client's {@link Account} with max balance.
     *
     * @param id is a client's identifier
     * @return {@link Account} with max balance
     */
    Optional<Account> getMaxAccountBalance(long id) throws IOException;

    /**
     * Returns set of client {@link Account}s which created date
     * more than comparing date.
     *
     * @param id   is a client's identifier
     * @param date for comparing
     * @return set of client {@link Account}s
     */
    Set<Account> getAllAccountsByDateMoreThen(long id, LocalDate date) throws IOException;

    /**
     * Returns sum balance for all client {@link Account}s.
     *
     * @param id is a client's identifier
     * @return sum balance in {@link BigDecimal}
     */
    BigDecimal getSumBalanceForAllClientAccounts(long id) throws IOException;
}
