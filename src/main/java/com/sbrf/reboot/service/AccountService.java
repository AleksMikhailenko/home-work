package com.sbrf.reboot.service;

import com.sbrf.reboot.repository.entity.Account;

public interface AccountService {

    /**
     * Returns <i>true</i> if account exist, otherwise <i>false</i>.
     *
     * @param id      an identifier
     * @param account {@link Account}'s object for searching
     * @return <i>true</i> if account exist
     */
    boolean isAccountExist(long id, Account account);
}
