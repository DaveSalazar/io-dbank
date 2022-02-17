package com.application.administration.core.account.application.check;

import com.application.administration.core.account.domain.AccountRepository;
import com.application.administration.core.shared.domain.Service;

@Service
public final class AccountChecker {

    private final AccountRepository repository;

    public AccountChecker(AccountRepository repository) {
        this.repository = repository;
    }

    public void check(String userId) {
        var acc = repository.searchAll();

    }
}
