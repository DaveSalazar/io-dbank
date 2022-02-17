package com.application.administration.core.account;

import com.application.administration.core.account.domain.AccountRepository;
import com.application.administration.core.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;

public abstract class AccountModuleUnitTestCase extends UnitTestCase {

    protected AccountRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(AccountRepository.class);
    }

}
