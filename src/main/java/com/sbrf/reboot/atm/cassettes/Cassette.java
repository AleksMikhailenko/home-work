package com.sbrf.reboot.atm.cassettes;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Cassette<E> {
    private List<E> banknotes;

    public int getCountBanknotes() {
        return banknotes.size();
    }
}
