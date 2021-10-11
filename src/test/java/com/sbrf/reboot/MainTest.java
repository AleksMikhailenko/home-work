package com.sbrf.reboot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void getContextFromXML() {
        assertNotNull(Main.getContextFromXML());
    }

    @Test
    void getContextFromJavaBasedConfig() {
        assertNotNull(Main.getContextFromJavaBasedConfig());
    }

    @Test
    void shouldBeNotEquals() {
        assertNotSame(Main.getContextFromXML(), Main.getContextFromJavaBasedConfig());
    }

    @Test
    void main() {
        Main.main(new String[]{"1", "2"});
        assertTrue(true);
    }
}