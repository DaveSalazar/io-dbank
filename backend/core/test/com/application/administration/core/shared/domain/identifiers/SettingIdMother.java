package com.application.administration.core.shared.domain.identifiers;

import com.application.administration.core.shared.domain.UuidMother;

public final class SettingIdMother {
    public static SettingId create(String value) {
        return new SettingId(value);
    }

    public static SettingId random() {
        return create(UuidMother.random());
    }

}