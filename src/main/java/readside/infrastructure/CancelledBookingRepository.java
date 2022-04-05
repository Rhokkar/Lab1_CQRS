package readside.infrastructure;

import readside.communication.dto.CancelledBooking;

import java.util.ArrayList;
import java.util.List;

public class CancelledBookingRepository {
    private final List<CancelledBooking> cancelledBookings = new ArrayList<>();

    public void add(CancelledBooking cancelledBooking) {
        cancelledBookings.add(cancelledBooking);
    }

    public List<CancelledBooking> all() {
        return cancelledBookings;
    }
}
