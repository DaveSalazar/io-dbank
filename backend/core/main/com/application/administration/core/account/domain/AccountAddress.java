package com.application.administration.core.account.domain;

import com.application.administration.core.shared.domain.value_object.StringValueObject;

public final class AccountAddress extends StringValueObject {
    public AccountAddress(String value) {
        super(value);
    }

    public AccountAddress() {
        super("");
    }
}
