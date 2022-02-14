package com.application.administration.core.setting.application;

import com.application.administration.core.shared.domain.bus.query.Response;

import java.util.List;

public final class SettingsResponse implements Response {
    private final List<SettingResponse> settings;

    public SettingsResponse(List<SettingResponse> settings) {
        this.settings = settings;
    }

    public List<SettingResponse> settings() {
        return settings;
    }
}
