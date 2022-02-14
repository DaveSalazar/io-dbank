package com.application.administration.core.shared.infrastructure.bus.command;

import com.application.administration.core.shared.domain.Service;
import com.application.administration.core.shared.domain.bus.command.Command;
import com.application.administration.core.shared.domain.bus.command.CommandHandler;
import com.application.administration.core.shared.domain.bus.command.CommandNotRegisteredError;
import org.reflections.Reflections;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Set;

import static com.application.administration.core.shared.domain.Constants.MAIN_PACKAGE_NAME;

@Service
public final class CommandHandlersInformation {
    HashMap<Class<? extends Command>, Class<? extends CommandHandler>> indexedCommandHandlers;

    public CommandHandlersInformation() {
        Reflections                          reflections = new Reflections(MAIN_PACKAGE_NAME);
        Set<Class<? extends CommandHandler>> classes     = reflections.getSubTypesOf(CommandHandler.class);

        indexedCommandHandlers = formatHandlers(classes);
    }

    public Class<? extends CommandHandler> search(Class<? extends Command> commandClass) throws CommandNotRegisteredError {
        Class<? extends CommandHandler> commandHandlerClass = indexedCommandHandlers.get(commandClass);

        if (null == commandHandlerClass) {
            throw new CommandNotRegisteredError(commandClass);
        }

        return commandHandlerClass;
    }

    private HashMap<Class<? extends Command>, Class<? extends CommandHandler>> formatHandlers(
        Set<Class<? extends CommandHandler>> commandHandlers
    ) {
        HashMap<Class<? extends Command>, Class<? extends CommandHandler>> handlers = new HashMap<>();

        for (Class<? extends CommandHandler> handler : commandHandlers) {
            ParameterizedType        paramType    = (ParameterizedType) handler.getGenericInterfaces()[0];
            Class<? extends Command> commandClass = (Class<? extends Command>) paramType.getActualTypeArguments()[0];

            handlers.put(commandClass, handler);
        }

        return handlers;
    }
}
