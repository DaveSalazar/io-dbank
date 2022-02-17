package com.application.administration.core.shared.domain.identifiers;

import com.application.administration.core.shared.domain.UuidMother;

public final class UserIdMother {
    public static UserId create(String value) {
        return new UserId(value);
    }

    public static UserId random() {
        return create(UuidMother.random());
    }

}