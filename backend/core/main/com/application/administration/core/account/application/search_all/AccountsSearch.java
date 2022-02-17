package com.application.administration.core.account.application.search_all;

import com.application.administration.core.account.domain.Account;
import com.application.administration.core.account.domain.AccountRepository;
import com.application.administration.core.shared.domain.Service;

import java.util.List;

@Service
public final class AccountsSearch {
    private final AccountRepository repository;

    public AccountsSearch(AccountRepository repository) {
        this.repository = repository;
    }

    public List<Account> search() {
        return repository.searchAll();
    }
}
