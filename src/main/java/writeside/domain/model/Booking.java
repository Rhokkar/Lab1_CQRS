package writeside.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public class Booking {
    private final UUID bookingId;
    private final LocalDate arrivalDate;
    private final LocalDate departureDate;
    private final Room room;
    private final Guest guest;

    public Booking(UUID bookingId, LocalDate arrivalDate, LocalDate departureDate, Room room, Guest guest) {
        this.bookingId = bookingId;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.room = room;
        this.guest = guest;
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

    public Room getRoom() {
        return room;
    }

    public Guest getGuest() {
        return guest;
    }
}