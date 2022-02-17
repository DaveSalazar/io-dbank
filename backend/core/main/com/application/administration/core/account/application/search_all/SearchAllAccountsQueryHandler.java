package com.application.administration.core.account.application.search_all;

import com.application.administration.core.account.application.AccountResponse;
import com.application.administration.core.account.application.AccountsResponse;
import com.application.administration.core.shared.domain.Service;
import com.application.administration.core.shared.domain.bus.query.QueryHandler;

import java.util.stream.Collectors;

@Service
public class SearchAllAccountsQueryHandler implements QueryHandler<SearchAllAccountsQuery, AccountsResponse> {

    private final AccountsSearch search;

    public SearchAllAccountsQueryHandler(AccountsSearch search) {
        this.search = search;
    }

    @Override
    public AccountsResponse handle(SearchAllAccountsQuery query) {
        return new AccountsResponse(
                search.search().stream().map(AccountResponse::fromAggregate).collect(Collectors.toList())
        );
    }
}
