package com.sbrf.reboot.repository;

import com.sbrf.reboot.repository.entity.Account;

import java.util.Set;

public interface AccountRepository {

    /**
     * Search client accounts by id.
     *
     * @param id an identifier
     * @return set of {@link Account}
     */
    Set<Account> getAllAccountsByClientId(long id);
}
