package com.application.administration.core.transaction.application.save;

import com.application.administration.core.shared.domain.bus.command.Command;

public class SaveTransactionCommand implements Command {

    private final String from;
    private final String to;
    private final Integer quantity;

    public SaveTransactionCommand(String from, String to, Integer quantity) {
        this.from = from;
        this.to = to;
        this.quantity = quantity;
    }

    public String from() {
        return from;
    }

    public String to() {
        return to;
    }

    public Integer quantity() {
        return quantity;
    }
}
