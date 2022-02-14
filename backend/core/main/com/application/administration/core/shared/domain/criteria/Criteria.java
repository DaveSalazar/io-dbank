package com.application.administration.core.shared.domain.criteria;

import java.util.Optional;

public final class Criteria {
    private final Filters           filters;
    private final FilterOrder filterOrder;
    private final Optional<Integer> limit;
    private final Optional<Integer> offset;

    public Criteria(Filters filters, FilterOrder filterOrder, Optional<Integer> limit, Optional<Integer> offset) {
        this.filters = filters;
        this.filterOrder = filterOrder;
        this.limit   = limit;
        this.offset  = offset;
    }

    public Criteria(Filters filters, FilterOrder filterOrder) {
        this.filters = filters;
        this.filterOrder = filterOrder;
        this.limit   = Optional.empty();
        this.offset  = Optional.empty();
    }

    public Filters filters() {
        return filters;
    }

    public FilterOrder order() {
        return filterOrder;
    }

    public Optional<Integer> limit() {
        return limit;
    }

    public Optional<Integer> offset() {
        return offset;
    }

    public boolean hasFilters() {
        return filters.filters().size() > 0;
    }

    public String serialize() {
        return String.format(
            "%s~~%s~~%s~~%s",
            filters.serialize(),
            filterOrder.serialize(),
            offset.orElse(0),
            limit.orElse(0)
        );
    }
}
