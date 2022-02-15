package com.application.administration.core.transaction;

import com.application.administration.core.shared.infrastructure.UnitTestCase;
import com.application.administration.core.transaction.domain.Transaction;
import com.application.administration.core.transaction.domain.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public abstract class TransactionModuleUnitTestCase extends UnitTestCase {

    protected TransactionRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(TransactionRepository.class);
    }

    public void shouldHaveSaved(Transaction transaction) {
        verify(repository, atLeastOnce()).save(transaction);
    }
}
