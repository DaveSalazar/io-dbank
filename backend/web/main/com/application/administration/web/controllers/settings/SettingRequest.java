package com.application.administration.web.controllers.settings;

public class SettingRequest {

    private String name;

    private String value;

    public SettingRequest(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
