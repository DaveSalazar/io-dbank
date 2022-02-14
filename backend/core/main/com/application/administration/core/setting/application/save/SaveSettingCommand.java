package com.application.administration.core.setting.application.save;

import com.application.administration.core.shared.domain.bus.command.Command;

public final class SaveSettingCommand implements Command {

    private final String id;
    private final String institutionId;
    private final String name;
    private final String description;
    private final String value;

    public SaveSettingCommand(String id, String institutionId, String name, String description, String value) {
        this.id = id;
        this.institutionId = institutionId;
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public String id() {
        return id;
    }

    public String institutionId() {
        return institutionId;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public String value() {
        return value;
    }
}
