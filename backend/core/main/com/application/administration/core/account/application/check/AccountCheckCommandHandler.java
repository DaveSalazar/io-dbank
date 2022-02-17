package com.application.administration.core.account.application.check;

import com.application.administration.core.shared.domain.bus.command.CommandHandler;

public final class AccountCheckCommandHandler implements CommandHandler<AccountCheckCommand> {

    private final AccountChecker checker;

    public AccountCheckCommandHandler(AccountChecker checker) {
        this.checker = checker;
    }

    @Override
    public void handle(AccountCheckCommand command) {
        checker.check(command.userId());
    }
}
