package com.application.administration.core.shared.domain.errors;

import com.application.administration.core.shared.domain.DomainError;

public class ServerError extends DomainError {
    public ServerError() {
        super("server_error", String.format("An error has occurred."));
    }
}
