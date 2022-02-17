package com.application.administration.web.controllers.accounts;

import com.application.administration.core.account.application.AccountsResponse;
import com.application.administration.core.account.application.search_all.SearchAllAccountsQuery;
import com.application.administration.core.setting.application.SettingsResponse;
import com.application.administration.core.setting.application.search_by_criteria.SettingsByCriteriaQuery;
import com.application.administration.core.shared.domain.DomainError;
import com.application.administration.core.shared.domain.bus.command.CommandBus;
import com.application.administration.core.shared.domain.bus.query.QueryBus;
import com.application.administration.core.shared.domain.bus.query.QueryHandlerExecutionError;
import com.application.administration.web.common.ApiController;
import com.application.administration.web.common.Constants;
import com.application.administration.web.common.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class AccountsGetController extends ApiController {

    protected AccountsGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(Constants.PREFIX + "/accounts")
    public List<Map<String, Serializable>> handle() throws QueryHandlerExecutionError {
        AccountsResponse response = ask(new SearchAllAccountsQuery());
        return response.data().stream().map(this::mapResponse).collect(Collectors.toList());
    }

    @Override
    public Map<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
