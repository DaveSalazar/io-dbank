package com.application.administration.core.transaction.domain;

import com.application.administration.core.shared.domain.criteria.Criteria;

import java.util.List;

public interface TransactionRepository {
    void save(Transaction data);
    List<Transaction> matching(Criteria criteria);
}
