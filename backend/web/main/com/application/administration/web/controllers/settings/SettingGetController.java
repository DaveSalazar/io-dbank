package com.application.administration.web.controllers.settings;

import com.application.administration.core.setting.application.SettingResponse;
import com.application.administration.core.setting.application.find.FindSettingQuery;
import com.application.administration.core.shared.domain.DomainError;
import com.application.administration.core.shared.domain.bus.command.CommandBus;
import com.application.administration.core.shared.domain.bus.query.QueryBus;
import com.application.administration.core.shared.domain.bus.query.QueryHandlerExecutionError;
import com.application.administration.web.common.ApiController;
import com.application.administration.web.common.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public final class SettingGetController extends ApiController {

    public SettingGetController(QueryBus queryBus,
                                CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(Constants.PREFIX + "/{institutionId}/settings/{id}")
    public Map<String, Serializable> handle(@PathVariable String id) throws QueryHandlerExecutionError {
        SettingResponse response = ask(new FindSettingQuery(id));
        return mapResponse(response);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
