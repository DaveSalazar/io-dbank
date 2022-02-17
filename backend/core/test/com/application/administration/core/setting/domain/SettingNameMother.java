package com.application.administration.core.setting.domain;

import com.application.administration.core.shared.domain.WordMother;

public final class SettingNameMother {
    public static SettingName create(String value) {
        return new SettingName(value);
    }

    public static SettingName random() {
        return create(WordMother.random());
    }
}