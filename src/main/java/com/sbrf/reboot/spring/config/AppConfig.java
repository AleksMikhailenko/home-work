package com.sbrf.reboot.spring.config;

import com.sbrf.reboot.spring.Account;
import com.sbrf.reboot.spring.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.HashSet;
import java.util.Set;

@Configuration
@PropertySource("classpath:app.properties")
public class AppConfig {

    @Autowired
    private Environment env;

    @Bean
    public Account getAccount() {
        return new Account(env.getProperty("account.number"));
    }

    @Bean
    public Client getClient() {
        Set<Account> accounts = new HashSet<>();
        accounts.add(getAccount());
        return new Client(env.getProperty("client.name"), accounts);
    }
}
