package com.application.administration.core.setting.domain;

import com.application.administration.core.shared.domain.DomainError;
import com.application.administration.core.shared.domain.identifiers.SettingId;

public final class SettingNotExists extends DomainError {

    public SettingNotExists(SettingId id) {
        super("setting_not_exist", String.format("The setting <%s> doesn't exists", id.value()));
    }
}
