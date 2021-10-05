package com.sbrf.reboot;

import com.sbrf.reboot.spring.Client;
import com.sbrf.reboot.spring.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        getContextFromXML();
        getContextFromJavaBasedConfig();
    }

    private static Client getContextFromXML() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        return context.getBean(Client.class);
    }

    private static Client getContextFromJavaBasedConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        return context.getBean(Client.class);
    }
}
