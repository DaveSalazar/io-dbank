package com.application.administration.core.shared.domain.value_object;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.application.administration.core.shared.domain.errors.InvalidJsonArrayFormat;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class JsonListValueObject {

    private String value;
    private List<HashMap<String, Serializable>> hashMaps;

    public JsonListValueObject(String value) {
        if(!value.isEmpty()) {
            try {
               this.hashMaps = new ObjectMapper().readValue(value, List.class);
            } catch (JsonProcessingException e) {
                throw new InvalidJsonArrayFormat(value);
            }
        }
        this.value = value;
    }

    public String value() {
        return value;
    }

    public List<HashMap<String, Serializable>> hashMaps() {
        return hashMaps;
    }
}
