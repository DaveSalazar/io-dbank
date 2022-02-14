package com.application.administration.core.shared.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.CaseFormat;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public final class Utils {

    private Utils() {
    }

    public static String dateToString(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static String dateToString(Timestamp timestamp) {
        return dateToString(timestamp.toLocalDateTime());
    }

    public static String jsonEncode(Map<String, Serializable> map) {
        try {
            return new ObjectMapper().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    public static Map<String, Serializable> jsonDecode(String body) {
        Map<String, Serializable> data;
        try {
            var objectMapper = new ObjectMapper();
            data = objectMapper.readValue(body, HashMap.class);
        } catch (IOException e) {
            data = null;
        }
        return data;
    }

    public static String toSnake(String text) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, text);
    }

    public static String toCamel(String text) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, text);
    }

    public static String toCamelFirstLower(String text) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, text);
    }


}
