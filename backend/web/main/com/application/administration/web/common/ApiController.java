package com.application.administration.web.common;

import com.application.administration.core.shared.domain.DomainError;
import com.application.administration.core.shared.domain.bus.command.Command;
import com.application.administration.core.shared.domain.bus.command.CommandBus;
import com.application.administration.core.shared.domain.bus.command.CommandHandlerExecutionError;
import com.application.administration.core.shared.domain.bus.query.Query;
import com.application.administration.core.shared.domain.bus.query.QueryBus;
import com.application.administration.core.shared.domain.bus.query.QueryHandlerExecutionError;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class ApiController {
    private final QueryBus queryBus;
    private final CommandBus commandBus;

    protected ApiController(QueryBus queryBus, CommandBus commandBus) {
        this.queryBus   = queryBus;
        this.commandBus = commandBus;
    }

    protected void dispatch(Command command) throws CommandHandlerExecutionError {
        commandBus.dispatch(command);
    }

    protected <R> R ask(Query query) throws QueryHandlerExecutionError {
        return queryBus.ask(query);
    }
    protected Map<String, Serializable> mapResponse(Object response) {
        var mapResponse = new HashMap<String, Serializable>();
        for (Field field: response.getClass().getDeclaredFields()) {
            try {
                Method fieldGetter = response.getClass().getMethod(field.getName());
                Object f = fieldGetter.invoke(response);
                mapResponse.put(field.getName(), (Serializable) f);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return mapResponse;
    }
     public abstract Map<Class<? extends DomainError>, HttpStatus> errorMapping();
}
