package com.sbrf.reboot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sbrf.reboot.dto.Convertible;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class XMLUtils {

    public static String toXML(Convertible obj) throws JsonProcessingException {
        ObjectMapper mapper = new XmlMapper();
        return mapper.writeValueAsString(obj);
    }

    public static Request fromXMLtoRequest(String s) throws JsonProcessingException {
        ObjectMapper mapper = new XmlMapper();
        return mapper.readValue(s, Request.class);
    }

    public static Response fromXMLtoResponse(String s) throws JsonProcessingException {
        ObjectMapper mapper = new XmlMapper();
        return mapper.readValue(s, Response.class);
    }
}
