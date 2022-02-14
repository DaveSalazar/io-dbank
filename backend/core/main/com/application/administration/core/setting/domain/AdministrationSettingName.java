package com.application.administration.core.setting.domain;

import com.application.administration.core.shared.domain.value_object.StringValueObject;

public final class AdministrationSettingName extends StringValueObject {
    public AdministrationSettingName(String value) {
        super(value);
    }

    public AdministrationSettingName() {
        super("");
    }
}
