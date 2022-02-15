package com.application.administration.core.transaction.application.search_by_criteria;

import com.application.administration.core.shared.domain.Service;
import com.application.administration.core.shared.domain.bus.query.QueryHandler;
import com.application.administration.core.shared.domain.criteria.FilterOrder;
import com.application.administration.core.shared.domain.criteria.Filters;
import com.application.administration.core.transaction.application.TransactionsResponse;

@Service
public class TransactionsByCriteriaQueryHandler implements QueryHandler<TransactionsByCriteriaQuery, TransactionsResponse> {

    private final TransactionsByCriteriaSearcher searcher;

    public TransactionsByCriteriaQueryHandler(TransactionsByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public TransactionsResponse handle(TransactionsByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        FilterOrder order   = FilterOrder.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}
