package com.application.administration.core.setting.application;

import com.application.administration.core.setting.domain.SettingName;
import com.application.administration.core.setting.domain.SettingNameMother;
import com.application.administration.core.setting.domain.SettingValue;
import com.application.administration.core.setting.domain.SettingValueMother;
import com.application.administration.core.shared.domain.identifiers.SettingId;
import com.application.administration.core.shared.domain.identifiers.SettingIdMother;
import com.application.administration.core.shared.domain.identifiers.UserId;
import com.application.administration.core.shared.domain.identifiers.UserIdMother;

public final class SettingResponseMother {
    public static SettingResponse create(SettingId id, UserId userId, SettingName name, SettingValue value) {
        return new SettingResponse(id.value(), userId.value(), name.value(), value.value());
    }

    public static SettingResponse random() {
        return create(SettingIdMother.random(), UserIdMother.random(), SettingNameMother.random(), SettingValueMother.random());
    }
}