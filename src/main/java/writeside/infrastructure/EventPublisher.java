package writeside.infrastructure;

import eventside.domain.model.BookingCancelledEvent;
import eventside.domain.model.BookingCreatedEvent;
import eventside.domain.model.Event;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.sound.midi.Soundbank;

@Component
public class EventPublisher {
    private final WebClient localApiClient = WebClient.create("http://localhost:8082");

    public EventPublisher() {
    }

    public Boolean publishEvent(BookingCreatedEvent event) {
        System.out.println(event);

        return localApiClient
                .post()
                .uri("/bookingCreatedEvent")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event), BookingCreatedEvent.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    public Boolean publishEvent(BookingCancelledEvent event) {
        System.out.println(event);

        return localApiClient
                .post()
                .uri("/bookingCancelledEvent")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event), BookingCancelledEvent.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
}
