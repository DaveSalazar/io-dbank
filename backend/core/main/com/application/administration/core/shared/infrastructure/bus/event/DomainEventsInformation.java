package com.application.administration.core.shared.infrastructure.bus.event;

import com.application.administration.core.shared.domain.Service;
import com.application.administration.core.shared.domain.bus.event.DomainEvent;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static com.application.administration.core.shared.domain.Constants.MAIN_PACKAGE_NAME;

@Service
public final class DomainEventsInformation {
    HashMap<String, Class<? extends DomainEvent>> indexedDomainEvents;

    public DomainEventsInformation() {
        Reflections                       reflections = new Reflections(MAIN_PACKAGE_NAME);
        Set<Class<? extends DomainEvent>> classes     = reflections.getSubTypesOf(DomainEvent.class);

        try {
            indexedDomainEvents = formatEvents(classes);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public Class<? extends DomainEvent> forName(String name) {
        return indexedDomainEvents.get(name);
    }

    public String forClass(Class<? extends DomainEvent> domainEventClass) {
        return indexedDomainEvents.entrySet()
                                  .stream()
                                  .filter(entry -> Objects.equals(entry.getValue(), domainEventClass))
                                  .map(Map.Entry::getKey)
                                  .findFirst().orElse("");
    }

    private HashMap<String, Class<? extends DomainEvent>> formatEvents(
        Set<Class<? extends DomainEvent>> domainEvents
    ) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        HashMap<String, Class<? extends DomainEvent>> events = new HashMap<>();

        for (Class<? extends DomainEvent> domainEvent : domainEvents) {
            DomainEvent nullInstance = domainEvent.getConstructor().newInstance();

            events.put((String) domainEvent.getMethod("eventName").invoke(nullInstance), domainEvent);
        }

        return events;
    }
}
