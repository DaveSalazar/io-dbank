package com.application.administration.core.setting.domain;

import com.application.administration.core.shared.domain.identifiers.AdministrationSettingId;
import com.application.administration.core.shared.domain.DomainError;

public final class AdministrationSettingNotExists extends DomainError {

    public AdministrationSettingNotExists(AdministrationSettingId id) {
        super("setting_not_exists", String.format("The setting <%s> not exists", id.value()));
    }
}
