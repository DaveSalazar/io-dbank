package com.application.administration.core.shared.domain.value_object;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Objects;

public abstract class JsonValueObject {

    private String value;

    public JsonValueObject(String value) {
        this.value = value;
    }

    public String value()  {
//        try {
//            ObjectMapper mapperObj = new ObjectMapper();
//            return mapperObj.writeValueAsString(value);
//        }catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
        return value;
    }

    public HashMap<String, Object> toHashMap() {
        try {
           return new ObjectMapper().readValue(value, HashMap.class);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonValueObject that = (JsonValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
