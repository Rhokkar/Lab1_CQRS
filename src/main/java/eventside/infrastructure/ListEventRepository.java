package eventside.infrastructure;

import eventside.domain.model.Event;
import eventside.domain.repository.EventRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListEventRepository implements EventRepository {
    private List<Event> events = new ArrayList<>();

    @Override
    public void processEvent(Event event) {
        events.add(event);
        // TODO: notify subscribed read repositories
    }
}
