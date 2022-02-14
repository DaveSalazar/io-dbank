package com.application.administration.core.shared.domain.value_object;

import java.time.LocalTime;
import java.util.Objects;

public abstract class TimeValueObject {
    private LocalTime value;

    public TimeValueObject(String value) {
        this.value = LocalTime.parse(value);
    }

    public LocalTime value() {
        return value;
    }

    @Override
    public String toString() {
        return this.value().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TimeValueObject)) {
            return false;
        }
        TimeValueObject that = (TimeValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
