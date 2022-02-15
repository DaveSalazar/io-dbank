package com.application.administration.web.controllers.transactions;

import com.application.administration.core.shared.domain.DomainError;
import com.application.administration.core.shared.domain.bus.command.CommandBus;
import com.application.administration.core.shared.domain.bus.query.QueryBus;
import com.application.administration.core.shared.domain.bus.query.QueryHandlerExecutionError;
import com.application.administration.core.transaction.application.TransactionsResponse;
import com.application.administration.core.transaction.application.search_by_criteria.TransactionsByCriteriaQuery;
import com.application.administration.web.common.ApiController;
import com.application.administration.web.common.Constants;
import com.application.administration.web.common.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public final class TransactionsGetController extends ApiController {

    private TransactionsGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(Constants.PREFIX + "/transactions")
    public List<Map<String, Serializable>> handle(@RequestParam Map<String, Serializable> params)
            throws QueryHandlerExecutionError {
        TransactionsResponse response = ask(
                new TransactionsByCriteriaQuery(
                        Utils.parseFilters(params),
                        Optional.ofNullable((String)params.get("order_by")),
                        Optional.ofNullable((String)params.get("order")),
                        Optional.ofNullable(Utils.getParamIntValue(params.get("limit"))),
                        Optional.ofNullable(Utils.getParamIntValue(params.get("offset")))
                )
        );
        return response.data().stream().map(this::mapResponse).collect(Collectors.toList());
    }


    @Override
    public Map<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
