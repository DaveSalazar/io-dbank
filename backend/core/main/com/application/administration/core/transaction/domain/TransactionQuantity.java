package com.application.administration.core.transaction.domain;

import com.application.administration.core.shared.domain.value_object.IntValueObject;

public final class TransactionQuantity extends IntValueObject {
    public TransactionQuantity(Integer value) {
        super(value);
    }

    public TransactionQuantity() {
        super(0);
    }
}
