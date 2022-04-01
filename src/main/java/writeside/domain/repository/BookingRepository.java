package writeside.domain.repository;

import writeside.domain.model.Booking;

import java.util.Optional;
import java.util.UUID;

public interface BookingRepository {
    void book(Booking booking);

    Optional<Booking> getBookingById(UUID bookingId);

    void cancelBooking(UUID bookingId);
}