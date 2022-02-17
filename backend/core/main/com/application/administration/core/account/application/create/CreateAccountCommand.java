package com.application.administration.core.account.application.create;

import com.application.administration.core.shared.domain.bus.command.Command;

public final class CreateAccountCommand implements Command {
    private final String userId;

    public CreateAccountCommand(String userId) {
        this.userId = userId;
    }

    public String userId() {
        return userId;
    }
}
