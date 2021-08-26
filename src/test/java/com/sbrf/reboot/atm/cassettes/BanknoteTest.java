package com.sbrf.reboot.atm.cassettes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BanknoteTest {

    @Test
    void getBanknoteType() {
        Banknote banknote = new Banknote();
        banknote.setType("OneHundred");

        assertEquals("OneHundred", banknote.getType());
    }
}