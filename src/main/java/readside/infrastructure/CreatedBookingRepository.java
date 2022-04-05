package readside.infrastructure;

import readside.communication.dto.CreatedBooking;

import java.util.ArrayList;
import java.util.List;

public class CreatedBookingRepository {
    private final List<CreatedBooking> bookings = new ArrayList<>();

    public void add(CreatedBooking booking) {
        bookings.add(booking);
    }

    public List<CreatedBooking> all() {
        return bookings;
    }
}
