package com.application.administration.core.setting.application.save;

import com.application.administration.core.shared.domain.bus.command.Command;

public final class SaveSettingCommand implements Command {

    private final String id;
    private final String userId;
    private final String name;
    private final String value;

    public SaveSettingCommand(String id, String userId, String name, String value) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.value = value;
    }

    public String id() {
        return id;
    }

    public String userId() {
        return userId;
    }

    public String name() {
        return name;
    }

    public String value() {
        return value;
    }
}
