package writeside.infrastructure;

import writeside.domain.model.Booking;
import writeside.domain.repository.BookingRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ListBookingRepository implements BookingRepository {
    private final List<Booking> repository = new ArrayList<>();

    @Override
    public void book(Booking booking) {
        repository.add(booking);
    }

    @Override
    public Optional<Booking> getBookingById(UUID bookingId) {
        return repository
                .stream()
                .filter(booking -> booking.getBookingId().equals(bookingId))
                .findFirst();
    }

    @Override
    public void cancelBooking(UUID bookingId) {
        Optional<Booking> matchingBooking = repository
                .stream()
                .filter(booking -> booking.getBookingId().equals(bookingId))
                .findFirst();

        repository.remove(matchingBooking.get());
    }
}