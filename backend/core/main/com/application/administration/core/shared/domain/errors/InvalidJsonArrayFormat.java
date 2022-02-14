package com.application.administration.core.shared.domain.errors;

import com.application.administration.core.shared.domain.DomainError;

public class InvalidJsonArrayFormat extends DomainError {
    public InvalidJsonArrayFormat(String value) {
        super("invalid_json_array_format", String.format("Format %s is invalid"));
    }
}
