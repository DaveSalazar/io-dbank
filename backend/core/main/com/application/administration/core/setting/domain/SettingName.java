package com.application.administration.core.setting.domain;

import com.application.administration.core.shared.domain.value_object.StringValueObject;

public final class SettingName extends StringValueObject {
    public SettingName(String value) {
        super(value);
    }

    public SettingName() {
        super("");
    }
}
