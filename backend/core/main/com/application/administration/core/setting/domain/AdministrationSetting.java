package com.application.administration.core.setting.domain;

import com.application.administration.core.shared.domain.AggregateRoot;
import com.application.administration.core.shared.domain.events.AdministrationSettingSavedDomainEvent;
import com.application.administration.core.shared.domain.identifiers.AdministrationSettingId;
import com.application.administration.core.shared.domain.identifiers.UserId;

public final class AdministrationSetting extends AggregateRoot {

    private final AdministrationSettingId id;
    private final UserId userId;
    private final AdministrationSettingName name;
    private final AdministrationSettingValue value;

    public AdministrationSetting(AdministrationSettingId id,
                                 UserId userId, AdministrationSettingName name, AdministrationSettingValue value) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.value = value;
    }

    private AdministrationSetting() {
        this.id = null;
        this.userId = null;
        this.name = null;
        this.value = null;
    }

    public static AdministrationSetting create(AdministrationSettingId id, UserId userId, AdministrationSettingName name,
                                       AdministrationSettingValue value) {
        var setting = new AdministrationSetting(id, userId, name, value);
        setting.record(new AdministrationSettingSavedDomainEvent(id.value(), name.value(), value.value()));

        return setting;
    }

    public AdministrationSettingId id() {
        return id;
    }

    public UserId userId() {
        return userId;
    }

    public AdministrationSettingName name() {
        return name;
    }

    public AdministrationSettingValue value() {
        return value;
    }
}
