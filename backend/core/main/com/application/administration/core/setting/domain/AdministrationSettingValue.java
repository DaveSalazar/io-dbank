package com.application.administration.core.setting.domain;

import com.application.administration.core.shared.domain.value_object.StringValueObject;

public final class AdministrationSettingValue extends StringValueObject {
    public AdministrationSettingValue(String value) {
        super(value);
    }

    public AdministrationSettingValue() {
        super("");
    }
}
