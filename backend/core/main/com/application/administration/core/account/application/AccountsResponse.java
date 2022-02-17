package com.application.administration.core.account.application;

import com.application.administration.core.account.domain.Account;
import com.application.administration.core.shared.domain.bus.query.Response;

import java.util.List;

public final class AccountsResponse implements Response {
    private final List<AccountResponse> data;

    public AccountsResponse(List<AccountResponse> data) {
        this.data = data;
    }

    public List<AccountResponse> data() {
        return data;
    }
}
