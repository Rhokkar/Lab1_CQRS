package eventside.domain.repository;

import eventside.domain.model.Event;

public interface EventRepository {
    void processEvent(Event event);
}
