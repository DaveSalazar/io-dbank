package com.application.administration.core.setting.domain;

import com.application.administration.core.setting.application.save.SaveSettingCommand;
import com.application.administration.core.shared.domain.identifiers.SettingId;
import com.application.administration.core.shared.domain.identifiers.SettingIdMother;
import com.application.administration.core.shared.domain.identifiers.UserId;
import com.application.administration.core.shared.domain.identifiers.UserIdMother;

public final class SettingMother {
    public static Setting create(SettingId id, UserId userId, SettingName name, SettingValue value) {
        return new Setting(id, userId, name, value);
    }

    public static Setting fromRequest(SaveSettingCommand request) {
        return create(
                SettingIdMother.create(request.id()),
                UserIdMother.create(request.userId()),
                SettingNameMother.create(request.name()),
                SettingValueMother.create(request.value())
        );
    }

    public static Setting random() {
        return create(SettingIdMother.random(), UserIdMother.random(), SettingNameMother.random(), SettingValueMother.random());
    }
}