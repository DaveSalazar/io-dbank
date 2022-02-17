package com.application.administration.core.setting.domain;

import com.application.administration.core.shared.domain.AggregateRoot;
import com.application.administration.core.shared.domain.events.AdministrationSettingSavedDomainEvent;
import com.application.administration.core.shared.domain.identifiers.SettingId;
import com.application.administration.core.shared.domain.identifiers.UserId;

import java.util.Objects;

public final class Setting extends AggregateRoot {

    private final SettingId id;
    private final UserId userId;
    private final SettingName name;
    private final SettingValue value;

    public Setting(SettingId id,
                   UserId userId, SettingName name, SettingValue value) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.value = value;
    }

    private Setting() {
        this.id = null;
        this.userId = null;
        this.name = null;
        this.value = null;
    }

    public static Setting create(SettingId id, UserId userId, SettingName name,
                                 SettingValue value) {
        var setting = new Setting(id, userId, name, value);
        setting.record(new AdministrationSettingSavedDomainEvent(id.value(), name.value(), value.value()));

        return setting;
    }

    public SettingId id() {
        return id;
    }

    public UserId userId() {
        return userId;
    }

    public SettingName name() {
        return name;
    }

    public SettingValue value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Setting setting = (Setting) o;
        return Objects.equals(id, setting.id) && Objects.equals(userId, setting.userId) && Objects.equals(name, setting.name) && Objects.equals(value, setting.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, name, value);
    }
}
