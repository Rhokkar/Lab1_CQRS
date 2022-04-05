package eventside.communication.rest;

import eventside.domain.model.BookingCancelledEvent;
import eventside.domain.model.BookingCreatedEvent;
import eventside.infrastructure.ListEventRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventRestController {
    private ListEventRepository repository = new ListEventRepository();

    @PostMapping(value = "/bookingCreatedEvent", consumes = "application/json", produces = "application/json")
    public boolean processBookingCreatedEvent(@RequestBody BookingCreatedEvent event) {
        repository.processEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }

    @PostMapping(value = "/bookingCancelledEvent", consumes = "application/json", produces = "application/json")
    public boolean processBookingCancelledEvent(@RequestBody BookingCancelledEvent event) {
        repository.processEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }
}
