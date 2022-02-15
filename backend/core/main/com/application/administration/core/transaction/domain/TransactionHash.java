package com.application.administration.core.transaction.domain;

import com.application.administration.core.shared.domain.value_object.StringValueObject;

public final class TransactionHash extends StringValueObject {
    public TransactionHash(String value) {
        super(value);
    }

    public TransactionHash() {
        super("");
    }
}
