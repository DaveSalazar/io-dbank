package com.application.administration.web.controllers.transactions;

import com.application.administration.core.shared.domain.DomainError;
import com.application.administration.core.shared.domain.bus.command.CommandBus;
import com.application.administration.core.shared.domain.bus.command.CommandHandlerExecutionError;
import com.application.administration.core.shared.domain.bus.query.QueryBus;
import com.application.administration.core.transaction.application.save.SaveTransactionCommand;
import com.application.administration.web.common.ApiController;
import com.application.administration.web.common.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin
public final class TransactionPutController extends ApiController {

    private TransactionPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping(Constants.PREFIX + "/transactions")
    public ResponseEntity create(@RequestBody TransactionRequest request)
            throws CommandHandlerExecutionError {

        dispatch(new SaveTransactionCommand(
                request.getFrom(),
                request.getTo(),
                request.getQuantity()
        ));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public Map<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
