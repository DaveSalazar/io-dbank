package com.application.administration.core.transaction.application.save;

import com.application.administration.core.shared.domain.Service;
import com.application.administration.core.shared.domain.bus.event.EventBus;
import com.application.administration.core.transaction.domain.Transaction;
import com.application.administration.core.transaction.domain.TransactionRepository;

@Service
public class TransactionSave {
    private final TransactionRepository repository;
    private final EventBus eventBus;

    public TransactionSave(TransactionRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void save(Transaction transaction) {
        repository.save(transaction);
        eventBus.publish(transaction.pullDomainEvents());
    }
}
