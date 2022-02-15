package com.application.administration.core.transaction.application.search_by_criteria;

import com.application.administration.core.shared.domain.Service;
import com.application.administration.core.shared.domain.criteria.Criteria;
import com.application.administration.core.shared.domain.criteria.FilterOrder;
import com.application.administration.core.shared.domain.criteria.Filters;
import com.application.administration.core.transaction.application.TransactionResponse;
import com.application.administration.core.transaction.application.TransactionsResponse;
import com.application.administration.core.transaction.domain.TransactionRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionsByCriteriaSearcher {
    private final TransactionRepository repository;

    public TransactionsByCriteriaSearcher(TransactionRepository repository) {
        this.repository = repository;
    }
    public TransactionsResponse search(
            Filters filters,
            FilterOrder order,
            Optional<Integer> limit,
            Optional<Integer> offset) {
        Criteria criteria = new Criteria(filters, order, limit, offset);

        return new TransactionsResponse(
                repository.matching(criteria)
                        .stream()
                        .map(TransactionResponse::fromAggregate)
                        .collect(Collectors.toList())
        );
    }
}
