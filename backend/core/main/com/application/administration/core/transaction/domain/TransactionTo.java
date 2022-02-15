package com.application.administration.core.transaction.domain;

import com.application.administration.core.shared.domain.value_object.StringValueObject;

public final class TransactionTo extends StringValueObject {
    public TransactionTo(String value) {
        super(value);
    }

    public TransactionTo() {
        super("");
    }
}
