package com.application.administration.core.setting.domain;

import com.application.administration.core.shared.domain.WordMother;

public final class SettingValueMother {
    public static SettingValue create(String value) {
        return new SettingValue(value);
    }

    public static SettingValue random() {
        return create(WordMother.random());
    }
}