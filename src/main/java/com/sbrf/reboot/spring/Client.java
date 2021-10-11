package com.sbrf.reboot.spring;

import lombok.Value;

import java.util.Set;

@Value
public class Client {

    /**
     * Client's name
     */
    String name;

    /**
     * Set of clients accounts
     */
    Set<Account> accounts;
}
