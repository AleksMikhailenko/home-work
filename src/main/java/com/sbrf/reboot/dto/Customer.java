package com.sbrf.reboot.dto;

import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class Customer {

    /**
     * Customer's age
     */
    int age;

    /**
     * Customer's name
     */
    String name;

    /**
     * Set of customers accounts
     */
    Set<Account> accounts;
}
