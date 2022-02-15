package com.application.administration.core.shared.infrastructure;

import com.application.administration.core.shared.domain.bus.event.DomainEvent;
import com.application.administration.core.shared.domain.bus.event.EventBus;
import com.application.administration.core.shared.domain.bus.query.Query;
import com.application.administration.core.shared.domain.bus.query.QueryBus;
import com.application.administration.core.shared.domain.bus.query.Response;
import org.junit.jupiter.api.BeforeEach;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public abstract class UnitTestCase {

    protected EventBus eventBus;
    protected QueryBus queryBus;

    @BeforeEach
    protected void setUp() {
        eventBus      = mock(EventBus.class);
        queryBus      = mock(QueryBus.class);
    }

    public void shouldHavePublished(List<DomainEvent> domainEvents) {
        verify(eventBus, atLeastOnce()).publish(domainEvents);
    }

    public void shouldHavePublished(DomainEvent domainEvent) {
        shouldHavePublished(Collections.singletonList(domainEvent));
    }

    public void shouldAsk(Query query, Response response) {
        when(queryBus.ask(query)).thenReturn(response);
    }
}
