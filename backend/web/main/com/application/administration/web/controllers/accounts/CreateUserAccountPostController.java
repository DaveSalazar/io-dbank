package com.application.administration.web.controllers.accounts;

import com.application.administration.core.account.application.create.CreateAccountCommand;
import com.application.administration.core.account.application.search_all.SearchAllAccountsQuery;
import com.application.administration.core.account.domain.CannotCreateAccount;
import com.application.administration.core.setting.application.save.SaveSettingCommand;
import com.application.administration.core.shared.domain.DomainError;
import com.application.administration.core.shared.domain.bus.command.CommandBus;
import com.application.administration.core.shared.domain.bus.command.CommandHandlerExecutionError;
import com.application.administration.core.shared.domain.bus.query.QueryBus;
import com.application.administration.web.common.ApiController;
import com.application.administration.web.common.Constants;
import com.application.administration.web.controllers.settings.SettingRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class CreateUserAccountPostController extends ApiController {

    protected CreateUserAccountPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(Constants.PREFIX + "/accounts/create")
    public ResponseEntity create(Principal principal)
            throws CommandHandlerExecutionError {
        String userId = principal.getName();
        dispatch(new CreateAccountCommand(userId));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public Map<Class<? extends DomainError>, HttpStatus> errorMapping() {
        Map<Class<? extends DomainError>, HttpStatus> errors =  new HashMap<>();
        errors.put(CannotCreateAccount.class, HttpStatus.BAD_REQUEST);
        return errors;
    }
}
