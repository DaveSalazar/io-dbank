package com.application.administration.core.account.application;

import com.application.administration.core.account.domain.Account;
import com.application.administration.core.shared.domain.bus.query.Response;

public final class AccountResponse implements Response {
    private final String address;

    public AccountResponse(String address) {
        this.address = address;
    }

    public static AccountResponse fromAggregate(Account account) {
        return new AccountResponse(account.address().value());
    }

    public String address() {
        return address;
    }
}
