package readside.communication.dto;

import java.util.UUID;

public class CancelledBooking {
    private final UUID bookingId;
    private final String reason;

    public CancelledBooking(UUID bookingId, String reason) {
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
