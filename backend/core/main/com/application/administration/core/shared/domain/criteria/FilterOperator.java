package com.application.administration.core.shared.domain.criteria;

public enum FilterOperator {
    EQUAL("="),
    NOT_EQUAL("!="),
    GT(">"),
    LT("<"),
    GE(">="),
    LE("<="),
    CONTAINS("CONTAINS"),
    NOT_CONTAINS("NOT_CONTAINS"),
    BETWEEN("BETWEEN");

    private final String operator;

    FilterOperator(String operator) {
        this.operator = operator;
    }

    public static FilterOperator fromValue(String value) {
        switch (value) {
            case "=": return FilterOperator.EQUAL;
            case "!=": return FilterOperator.NOT_EQUAL;
            case ">": return FilterOperator.GT;
            case "<": return FilterOperator.LT;
            case ">=": return FilterOperator.GE;
            case "<=": return FilterOperator.LE;
            case "CONTAINS": return FilterOperator.CONTAINS;
            case "NOT_CONTAINS": return FilterOperator.NOT_CONTAINS;
            case "BETWEEN": return FilterOperator.BETWEEN;
            default: return null;
        }
    }

    public boolean isPositive() {
        return this != NOT_EQUAL && this != NOT_CONTAINS;
    }

    public String value() {
        return operator;
    }
}
