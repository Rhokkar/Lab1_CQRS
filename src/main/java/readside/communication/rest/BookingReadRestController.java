package readside.communication.rest;

import eventside.domain.model.BookingCancelledEvent;
import eventside.domain.model.BookingCreatedEvent;
import eventside.domain.model.Event;
import org.springframework.web.bind.annotation.*;
import readside.communication.dto.CreatedBooking;
import readside.communication.dto.CancelledBooking;
import readside.infrastructure.CreatedBookingRepository;
import readside.infrastructure.CancelledBookingRepository;

import java.util.List;

@RestController
public class BookingReadRestController {
    private final CreatedBookingRepository createdBookingRepository = new CreatedBookingRepository();
    private final CancelledBookingRepository cancelledBookingRepository = new CancelledBookingRepository();

    @PostMapping(value = "/bookingCreatedEvent", consumes = "application/json", produces = "application/json")
    public boolean bookingCreatedEvent(@RequestBody BookingCreatedEvent event) {
        CreatedBooking booking = new CreatedBooking(event.getBookingId(), event.getArrivalDate(), event.getDepartureDate(), event.getRoomNumber(), event.getGuestName());
        createdBookingRepository.add(booking);

        return true;
    }

    @PostMapping(value = "/bookingCancelledEvent", consumes = "application/json", produces = "application/json")
    public boolean bookingCancelledEvent(@RequestBody BookingCancelledEvent event) {
        CancelledBooking cancelledBooking = new CancelledBooking(event.getBookingId(), event.getReason());
        cancelledBookingRepository.add(cancelledBooking);

        return true;
    }

    @GetMapping(value = "/createdBookings")
    public List<CreatedBooking> createdBookings() {
        return createdBookingRepository.all();
    }

    @GetMapping(value = "/cancelledBookings")
    public List<CancelledBooking> cancelledBookings() {
        return cancelledBookingRepository.all();
    }
}
