package eventside.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public class BookingCancelledEvent implements Event {
    private final UUID bookingId;
    private final LocalDate arrivalDate;
    private final LocalDate departureDate;

    public BookingCancelledEvent(UUID bookingId, LocalDate arrivalDate, LocalDate departureDate) {
        this.bookingId = bookingId;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }
}
