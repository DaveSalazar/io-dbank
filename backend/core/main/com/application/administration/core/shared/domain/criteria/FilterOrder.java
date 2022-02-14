package com.application.administration.core.shared.domain.criteria;

import java.util.Optional;

public final class FilterOrder {
    private final OrderBy   orderBy;
    private final OrderType orderType;

    public FilterOrder(OrderBy orderBy, OrderType orderType) {
        this.orderBy   = orderBy;
        this.orderType = orderType;
    }

    public static FilterOrder fromValues(Optional<String> orderBy, Optional<String> orderType) {
        return orderBy.map(order -> new FilterOrder(new OrderBy(order), OrderType.valueOf(orderType.orElse("ASC"))))
                      .orElseGet(FilterOrder::none);
    }

    public static FilterOrder none() {
        return new FilterOrder(new OrderBy(""), OrderType.NONE);
    }

    public static FilterOrder desc(String orderBy) {
        return new FilterOrder(new OrderBy(orderBy), OrderType.DESC);
    }

    public static FilterOrder asc(String orderBy) {
        return new FilterOrder(new OrderBy(orderBy), OrderType.ASC);
    }

    public OrderBy orderBy() {
        return orderBy;
    }

    public OrderType orderType() {
        return orderType;
    }

    public boolean hasOrder() {
        return !orderType.isNone();
    }

    public String serialize() {
        return String.format("%s.%s", orderBy.value(), orderType.value());
    }
}
