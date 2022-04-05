package writeside.infrastructure;

import writeside.domain.model.Booking;
import writeside.domain.model.Guest;
import writeside.domain.model.Room;
import writeside.domain.repository.BookingRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ListBookingRepository implements BookingRepository {
    private final List<Booking> repository = new ArrayList<>(List.of(new Booking(
            UUID.fromString("3c790550-18a1-402d-b75f-39b8256392af"),
            LocalDate.now(),
            LocalDate.now().plusDays(10),
            new Room("104"),
            new Guest(UUID.fromString("bbf394dc-5bf4-4be4-9419-5632d6ce1307"), "Elias")
    )));

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
        Optional<Booking> matchingBooking = getBookingById(bookingId);

        repository.remove(matchingBooking.get());
    }
}