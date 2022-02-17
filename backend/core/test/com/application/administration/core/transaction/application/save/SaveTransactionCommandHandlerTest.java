package com.application.administration.core.transaction.application.save;

import com.application.administration.core.transaction.TransactionModuleUnitTestCase;
import org.junit.jupiter.api.BeforeEach;

class SaveTransactionCommandHandlerTest extends TransactionModuleUnitTestCase {

    private SaveTransactionCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        handler = new SaveTransactionCommandHandler(new TransactionSave(repository, eventBus));
    }
}