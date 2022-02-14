package com.application.administration.web.controllers.settings;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public final class SettingsGetController extends ApiController {

    public SettingsGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(Constants.PREFIX + "/settings")
    public List<Map<String, Serializable>> handle(@RequestParam Map<String, Serializable> params, Principal principal)
            throws QueryHandlerExecutionError {
        SettingsResponse response = ask(
                new SettingsByCriteriaQuery(
                        Utils.parseFilters(params),
                        Optional.ofNullable((String)params.get("order_by")),
                        Optional.ofNullable((String)params.get("order")),
                        Optional.ofNullable(Utils.getParamIntValue(params.get("limit"))),
                        Optional.ofNullable(Utils.getParamIntValue(params.get("offset")))
                )
        );
        return response.settings().stream().map(this::mapResponse).collect(Collectors.toList());
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
