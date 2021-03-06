package eventside.domain.model;

import java.util.UUID;

public class BookingCancelledEvent extends Event {
    private final UUID bookingId;
    private final String reason;

    public BookingCancelledEvent(UUID bookingId, String reason) {
        this.bookingId = bookingId;
        this.reason = reason;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public String getReason() {
        return reason;
    }
}
