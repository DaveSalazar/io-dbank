package com.application.administration.core.setting.application;

import com.application.administration.core.setting.domain.AdministrationSetting;
import com.application.administration.core.shared.domain.bus.query.Response;

public final class SettingResponse implements Response {

    private final String id;
    private final String institutionId;
    private final String name;
    private final String description;
    private final String value;

    public SettingResponse(String id, String institutionId, String name, String description, String value) {
        this.id = id;
        this.institutionId = institutionId;
        this.name = name;
        this.description = description;
        this.value = value;
    }
    
    public static SettingResponse fromAggregate(AdministrationSetting setting) {
        return new SettingResponse(
                setting.id().value(),
                setting.institutionId().value(),
                setting.name().value(),
                setting.description().value(),
                setting.value().value()
        );
    }

    public String institutionId() {
        return institutionId;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public String value() {
        return value;
    }
}
