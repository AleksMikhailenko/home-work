package com.sbrf.reboot.repository.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Account {

    /**
     * Identifier for client
     */
    private long clientId;

    /**
     * Number of a client account
     */
    private String accountNumber;

    @Override
    public String toString() {
        return "{" + System.lineSeparator() +
                "    \"clientId\": " + clientId + "," + System.lineSeparator() +
                "    \"number\": \"" + accountNumber + "\"" + System.lineSeparator() +
                "}";
    }
}
