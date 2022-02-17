package com.application.administration.core.account.domain;

import com.application.administration.core.shared.domain.DomainError;

public class CannotCreateAccount extends DomainError {
    public CannotCreateAccount(String userId) {
        super("cannot_create_account", String.format("The account for user id: <%s> couldn't be created", userId));
    }
}
