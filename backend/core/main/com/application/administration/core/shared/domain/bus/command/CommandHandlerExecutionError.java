package com.application.administration.core.shared.domain.bus.command;

public final class CommandHandlerExecutionError extends RuntimeException {
    public CommandHandlerExecutionError(Throwable cause) {
        super(cause);
    }
}
