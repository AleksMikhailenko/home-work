package com.sbrf.reboot.repository;

import com.sbrf.reboot.repository.entity.Account;

import java.io.IOException;
import java.util.Set;

public interface AccountRepository {

    /**
     * Search client accounts by id.
     *
     * @param id an identifier
     * @return set of {@link Account}
     */
    Set<Account> getAllAccountsByClientId(long id) throws IOException;

    /**
     * Update client account number by id.
     *
     * @param id        an identifier
     * @param oldNumber a old value
     * @param newNumber a new value
     */
    void updateAccountNumberByClientId(long id, String oldNumber, String newNumber) throws IOException;
}
