package com.sbrf.reboot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class XMLUtilsTest {

    @SneakyThrows
    @Test
    void toXMLRequest() {
        Request request = new Request("ATM12345");
        assertTrue(XMLUtils.toXML(request).contains("atmNumber"));
    }

    @SneakyThrows
    @Test
    void toXMLResponse() {
        Response response = new Response("SUCCESS");
        assertTrue(XMLUtils.toXML(response).contains("statusCode"));
    }

    @Test
    void XMLtoRequest() throws JsonProcessingException {
        Request request = XMLUtils.fromXMLtoRequest("<Request><atmNumber>ATM12345</atmNumber></Request>");
        assertEquals("ATM12345", request.getAtmNumber());
    }

    @Test
    void XMLtoResponse() throws JsonProcessingException {
        Response response = XMLUtils.fromXMLtoResponse("<Response><statusCode>SUCCESS</statusCode></Response>");
        assertEquals("SUCCESS", response.getStatusCode());
    }

}