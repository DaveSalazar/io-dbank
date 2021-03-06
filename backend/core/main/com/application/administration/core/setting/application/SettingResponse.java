package com.application.administration.core.setting.application;

import com.application.administration.core.setting.domain.Setting;
import com.application.administration.core.shared.domain.bus.query.Response;

import java.util.Objects;

public final class SettingResponse implements Response {

    private final String id;
    private final String userId;
    private final String name;
    private final String value;

    public SettingResponse(String id, String userId, String name, String value) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.value = value;
    }
    
    public static SettingResponse fromAggregate(Setting setting) {
        return new SettingResponse(
                setting.id().value(),
                setting.userId().value(),
                setting.name().value(),
                setting.value().value()
        );
    }

    public String id() {
        return id;
    }

    public String userId() {
        return userId;
    }

    public String name() {
        return name;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SettingResponse that = (SettingResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(name, that.name) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, name, value);
    }
}
