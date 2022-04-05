package eventside.infrastructure;

import eventside.domain.model.BookingCancelledEvent;
import eventside.domain.model.BookingCreatedEvent;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class EventPublisher {
    public Boolean publishEvent(WebClient subscriber, BookingCreatedEvent event) {
        System.out.println(event);

        return subscriber
                .post()
                .uri("/bookingCreatedEvent")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event), BookingCreatedEvent.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    public Boolean publishEvent(WebClient subscriber, BookingCancelledEvent event) {
        System.out.println(event);

        return subscriber
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
