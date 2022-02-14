package com.application.administration.core.setting.domain;

import com.application.administration.core.shared.domain.AggregateRoot;
import com.application.administration.core.shared.domain.events.AdministrationSettingSavedDomainEvent;
import com.application.administration.core.shared.domain.identifiers.AdministrationSettingId;
import com.application.administration.core.shared.domain.identifiers.InstitutionId;

public final class AdministrationSetting extends AggregateRoot {

    private final AdministrationSettingId id;
    private final InstitutionId institutionId;
    private final AdministrationSettingDescription description;
    private final AdministrationSettingName name;
    private final AdministrationSettingValue value;

    public AdministrationSetting(AdministrationSettingId id, InstitutionId institutionId, AdministrationSettingDescription description,
                                 AdministrationSettingName name, AdministrationSettingValue value) {
        this.id = id;
        this.institutionId = institutionId;
        this.description = description;
        this.name = name;
        this.value = value;
    }

    public AdministrationSetting() {
        this.id = null;
        this.institutionId = null;
        this.description = null;
        this.name = null;
        this.value = null;
    }

    public static AdministrationSetting create(AdministrationSettingId id, InstitutionId institutionId,
                                        AdministrationSettingDescription description,AdministrationSettingName name,
                                       AdministrationSettingValue value) {
        var setting = new AdministrationSetting(id, institutionId, description, name, value);
        setting.record(new AdministrationSettingSavedDomainEvent(id.value(), institutionId.value(),
                description.value(), name.value(), value.value()));

        return setting;
    }

    public AdministrationSettingId id() {
        return id;
    }

    public InstitutionId institutionId() {
        return institutionId;
    }

    public AdministrationSettingDescription description() {
        return description;
    }

    public AdministrationSettingName name() {
        return name;
    }

    public AdministrationSettingValue value() {
        return value;
    }
}
