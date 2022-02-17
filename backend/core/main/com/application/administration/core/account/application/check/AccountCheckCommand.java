package com.application.administration.core.account.application.check;

import com.application.administration.core.shared.domain.bus.command.Command;

public final class AccountCheckCommand implements Command {
    private final String userId;

    public AccountCheckCommand(String userId) {
        this.userId = userId;
    }

    public String userId() {
        return userId;
    }
}
