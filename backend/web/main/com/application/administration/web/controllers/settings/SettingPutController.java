package com.application.administration.web.controllers.settings;

import com.application.administration.core.setting.application.save.SaveSettingCommand;
import com.application.administration.core.shared.domain.DomainError;
import com.application.administration.core.shared.domain.bus.command.CommandBus;
import com.application.administration.core.shared.domain.bus.command.CommandHandlerExecutionError;
import com.application.administration.core.shared.domain.bus.query.QueryBus;
import com.application.administration.web.common.ApiController;
import com.application.administration.web.common.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;

@RestController
@CrossOrigin
public final class SettingPutController extends ApiController {

    public SettingPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping(Constants.PREFIX + "/settings/{id}")
    public ResponseEntity create(@PathVariable String id, @RequestBody SettingRequest request, Principal principal)
            throws CommandHandlerExecutionError {
        String userId = principal.getName();
        dispatch(new SaveSettingCommand(
                id,
                userId,
                request.getName(),
                request.getValue()
        ));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
