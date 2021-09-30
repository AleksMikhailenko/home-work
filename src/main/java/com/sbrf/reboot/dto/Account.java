package com.sbrf.reboot.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
@Builder
public class Account {

    /**
     * Identifier for client
     */
    long id;

    /**
     * Number of a client account
     */
    String accountNumber;

    /**
     * Create date of a client account
     */
    LocalDate createDate;

    /**
     * Account balance
     */
    BigDecimal balance;

    /**
     * Account's currency
     */
    String currency;

    @Override
    public String toString() {
        return "{" + System.lineSeparator() +
                "    \"clientId\": " + id + "," + System.lineSeparator() +
                "    \"number\": \"" + accountNumber + "\"" + System.lineSeparator() +
                "}";
    }
}
