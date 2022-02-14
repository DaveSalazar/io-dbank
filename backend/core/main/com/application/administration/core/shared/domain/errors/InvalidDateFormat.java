package com.application.administration.core.shared.domain.errors;


import com.application.administration.core.shared.domain.DomainError;

public class InvalidDateFormat extends DomainError {

    public InvalidDateFormat(String date) {
        super("invalid_date_format", String.format("%s format not valid", date));
    }
}
