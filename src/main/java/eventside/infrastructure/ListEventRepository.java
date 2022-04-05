package eventside.infrastructure;

import eventside.domain.model.BookingCancelledEvent;
import eventside.domain.model.BookingCreatedEvent;
import eventside.domain.model.Event;
import eventside.domain.repository.EventRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListEventRepository implements EventRepository {
    private List<Event> events = new ArrayList<>();
    private List<WebClient> subscribers = List.of(WebClient.create("http://localhost:8083"));

    @Override
    public void processEvent(Event event) {
        saveEvent(event);

        if (event instanceof BookingCreatedEvent) {
            notifySubscribers((BookingCreatedEvent) event);
        }

        if (event instanceof BookingCancelledEvent) {
            notifySubscribers((BookingCancelledEvent) event);
        }
    }

    private void saveEvent(Event event) {
        events.add(event);
    }

    private void notifySubscribers(BookingCreatedEvent event) {
        subscribers.forEach(subscriber -> new EventPublisher().publishEvent(subscriber, event));
    }

    private void notifySubscribers(BookingCancelledEvent event) {
        subscribers.forEach(subscriber -> new EventPublisher().publishEvent(subscriber, event));
    }
}
