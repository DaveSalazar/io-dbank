package com.application.administration.core.transaction.infrastructure.persistence;

import com.application.administration.core.shared.domain.Service;
import com.application.administration.core.shared.domain.criteria.Criteria;
import com.application.administration.core.transaction.domain.Transaction;
import com.application.administration.core.transaction.domain.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryTransactionRepository implements TransactionRepository {

    private List<Transaction> data = new ArrayList<>();

    @Override
    public void save(Transaction data) {
        this.data.add(data);
    }

    @Override
    public List<Transaction> matching(Criteria criteria) {
        return this.data;
    }
}
