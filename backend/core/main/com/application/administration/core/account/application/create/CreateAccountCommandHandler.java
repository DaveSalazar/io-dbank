package com.application.administration.core.account.application.create;

import com.application.administration.core.shared.domain.Service;
import com.application.administration.core.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateAccountCommandHandler implements CommandHandler<CreateAccountCommand> {

    private final AccountCreate checker;

    public CreateAccountCommandHandler(AccountCreate checker) {
        this.checker = checker;
    }

    @Override
    public void handle(CreateAccountCommand command) {
        checker.create(command.userId());
    }
}
