package com.application.administration.core.transaction.domain;

import com.application.administration.core.shared.domain.value_object.StringValueObject;

public final class TransactionFrom extends StringValueObject {
    public TransactionFrom(String value) {
        super(value);
    }

    public TransactionFrom() {
        super("");
    }
}
