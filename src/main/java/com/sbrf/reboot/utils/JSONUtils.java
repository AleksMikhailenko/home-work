package com.sbrf.reboot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.sbrf.reboot.dto.Convertible;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JSONUtils {
    public static String toJSON(Convertible obj) throws JsonProcessingException {
        ObjectMapper mapper = new JsonMapper();
        return mapper.writeValueAsString(obj);
    }

    public static Request fromJSONtoRequest(String s) throws JsonProcessingException {
        ObjectMapper mapper = new JsonMapper();
        return mapper.readValue(s, Request.class);
    }

    public static Response fromJSONtoResponse(String s) throws JsonProcessingException {
        ObjectMapper mapper = new JsonMapper();
        return mapper.readValue(s, Response.class);
    }
}
