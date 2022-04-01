package writeside.application.api;

import java.time.LocalDate;
import java.util.UUID;

public interface BookingWriteService {
    void book(LocalDate arrivalDate, LocalDate departureDate, String roomNumber, UUID guestId);

    void cancelBooking(UUID bookingId);
}
