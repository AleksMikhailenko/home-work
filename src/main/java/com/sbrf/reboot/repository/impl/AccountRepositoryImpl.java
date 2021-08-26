package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.repository.AccountRepository;
import com.sbrf.reboot.repository.entity.Account;
import lombok.AllArgsConstructor;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

    private String path;

    @Override
    public Set<Account> getAllAccountsByClientId(long id) throws IOException {
        String data = getDataFromSource();
        Set<String> allClientAccountsNumber = retrieveAllClientAccountsNumber(data, id);

        return allClientAccountsNumber.stream()
                .map(accountNumber -> new Account(id, accountNumber))
                .collect(Collectors.toSet());
    }

    @Override
    public void updateAccountNumberByClientId(long id, String oldNumber, String newNumber) throws IOException {
        String data = getDataFromSource();

        Map<Long, List<Account>> map = retrieveClientsData(data);
        updateAccountNumber(map.get(id), id, oldNumber, newNumber);

        writeChangesToFile(map);
    }

    private String getDataFromSource() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line.replace(" ", ""));
            }
        }

        return stringBuilder.toString();
    }

    private Set<String> retrieveAllClientAccountsNumber(String source, long id) {
        Set<String> set = new HashSet<>();

        String[] objects = source.split("},\\{");
        for (String obj : objects) {
            String[] split = obj.replaceAll("[\\[\\]{}\"]", "").split("[: ,]");
            long key = Long.parseLong(split[1]);
            if (key == id) {
                set.add(split[3]);
            }
        }

        return set;
    }

    private Map<Long, List<Account>> retrieveClientsData(String source) {
        Map<Long, List<Account>> map = new HashMap<>();

        String[] objects = source.split("},\\{");
        for (String obj : objects) {
            String[] split = obj.replaceAll("[\\[\\]{}\"]", "").split("[: ,]");
            long key = Long.parseLong(split[1]);
            map.computeIfAbsent(key, k -> new ArrayList<>())
                    .add(new Account(key, split[3]));
        }
        return map;
    }

    private void updateAccountNumber(List<Account> accounts, long id, String oldNumber, String newNumber) {
        for (int i = 0; i < accounts.size(); i++) {
            Account elem = accounts.get(i);
            if (elem.getAccountNumber().equals(oldNumber)) {
                accounts.set(i, new Account(id, newNumber));
            }
        }
    }

    private void writeChangesToFile(Map<Long, List<Account>> map) throws IOException {
        List<Account> accounts = new ArrayList<>();
        for (List<Account> list : map.values()) {
            accounts.addAll(list);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(String.valueOf(accounts));
        }
    }
}
