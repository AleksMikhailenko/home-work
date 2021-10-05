package com.sbrf.reboot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MainTest {

    @Test
    void getContextFromXML() {
        assertNotNull(Main.getContextFromXML());
    }

    @Test
    void getContextFromJavaBasedConfig() {
        assertNotNull(Main.getContextFromJavaBasedConfig());
    }
}