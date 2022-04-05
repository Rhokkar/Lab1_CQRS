package readside.communication.dto;

import java.time.LocalDate;
import java.util.UUID;

public class CreatedBooking {
    private final UUID bookingId;
    private final LocalDate arrivalDate;
    private final LocalDate departureDate;
    private final String roomNumber;
    private final String guestName;

    public CreatedBooking(UUID bookingId, LocalDate arrivalDate, LocalDate departureDate, String roomNumber, String guestName) {
        this.bookingId = bookingId;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.roomNumber = roomNumber;
        this.guestName = guestName;
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

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getGuestName() {
        return guestName;
    }
}
