package com.application.administration.core.transaction.infrastructure.persistence;

import com.application.administration.core.shared.domain.criteria.Criteria;
import com.application.administration.core.transaction.domain.Transaction;
import com.application.administration.core.transaction.domain.TransactionRepository;

import java.util.List;

public class Web3TransactionRepository implements TransactionRepository {

    @Override
    public void save(Transaction data) {

    }

    @Override
    public List<Transaction> matching(Criteria criteria) {
        return null;
    }
}
