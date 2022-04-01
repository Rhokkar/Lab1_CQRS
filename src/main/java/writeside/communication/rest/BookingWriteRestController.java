package writeside.communication.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import writeside.application.api.BookingWriteService;
import writeside.application.impl.BookingWriteServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestController
public class BookingWriteRestController {
    private BookingWriteService bookingWriteService = new BookingWriteServiceImpl();

    @PostMapping(value = "/book")
    public boolean book(@RequestParam String arrivalDateString, @RequestParam String departureDateString, @RequestParam String roomNumber, @RequestParam String guestIdString) {
        LocalDate arrivalDate = LocalDate.parse(arrivalDateString, DateTimeFormatter.ISO_DATE);
        LocalDate departureDate = LocalDate.parse(departureDateString, DateTimeFormatter.ISO_DATE);
        UUID guestId = UUID.fromString(guestIdString);

        bookingWriteService.book(arrivalDate, departureDate, roomNumber, guestId);

        return true;
    }

    @PostMapping(value = "/cancelBooking")
    public boolean cancelBooking(@RequestParam String bookingIdString) {
        UUID bookingId = UUID.fromString(bookingIdString);

        bookingWriteService.cancelBooking(bookingId);

        return true;
    }
}
