package com.application.administration.core.transaction.application.save;

import com.application.administration.core.shared.domain.Service;
import com.application.administration.core.shared.domain.bus.command.CommandHandler;
import com.application.administration.core.transaction.domain.Transaction;
import com.application.administration.core.transaction.domain.TransactionFrom;
import com.application.administration.core.transaction.domain.TransactionHash;
import com.application.administration.core.transaction.domain.TransactionQuantity;
import com.application.administration.core.transaction.domain.TransactionTo;

@Service
public class SaveTransactionCommandHandler implements CommandHandler<SaveTransactionCommand> {

    private final TransactionSave save;

    public SaveTransactionCommandHandler(TransactionSave save) {
        this.save = save;
    }

    @Override
    public void handle(SaveTransactionCommand command) {
        var hash = new TransactionHash("");
        var from = new TransactionFrom(command.from());
        var to = new TransactionTo(command.to());
        var quantity = new TransactionQuantity(command.quantity());

        var transaction = Transaction.create(hash, from, to, quantity);

        save.save(transaction);
    }
}
