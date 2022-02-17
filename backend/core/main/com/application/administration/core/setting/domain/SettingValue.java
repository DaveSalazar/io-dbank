package com.application.administration.core.setting.domain;

import com.application.administration.core.shared.domain.value_object.StringValueObject;

public final class SettingValue extends StringValueObject {
    public SettingValue(String value) {
        super(value);
    }

    public SettingValue() {
        super("");
    }
}
