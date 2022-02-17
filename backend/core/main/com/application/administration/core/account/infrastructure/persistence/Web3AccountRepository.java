package com.application.administration.core.account.infrastructure.persistence;

import com.application.administration.core.account.domain.Account;
import com.application.administration.core.account.domain.AccountRepository;
import com.application.administration.core.shared.domain.Service;
import org.web3j.protocol.Web3j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Web3AccountRepository implements AccountRepository {
    private final Web3j web3j;

    public Web3AccountRepository(Web3j web3j) {
        this.web3j = web3j;
    }

    @Override
    public List<Account> searchAll() {
        List<Account> accounts = new ArrayList<>();
        try {
            accounts = web3j.ethAccounts().send()
                    .getAccounts()
                    .stream().map(Account::fromPrimitives).collect(Collectors.toList());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public Optional<Account> find(Account data) {
        return Optional.empty();
    }
}
