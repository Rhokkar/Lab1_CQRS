package writeside.application.impl;

import eventside.domain.model.BookingCreatedEvent;
import writeside.application.api.BookingWriteService;
import writeside.domain.model.Booking;
import writeside.domain.model.Guest;
import writeside.domain.model.Room;
import writeside.domain.repository.BookingRepository;
import writeside.domain.repository.GuestRepository;
import writeside.domain.repository.RoomRepository;
import writeside.infrastructure.EventPublisher;
import writeside.infrastructure.ListBookingRepository;
import writeside.infrastructure.ListGuestRepository;
import writeside.infrastructure.ListRoomRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public class BookingWriteServiceImpl implements BookingWriteService {
    EventPublisher eventPublisher = new EventPublisher();
    BookingRepository bookingRepository = new ListBookingRepository();
    GuestRepository guestRepository = new ListGuestRepository();
    RoomRepository roomRepository = new ListRoomRepository();

    @Override
    public void book(LocalDate arrivalDate, LocalDate departureDate, String roomNumber, UUID guestId) {
        Optional<Guest> guest = guestRepository.getGuestById(guestId);
        Optional<Room> room = roomRepository.getRoomByNumber(roomNumber);

        if (arrivalDate.isAfter(departureDate)) {
            throw new IllegalArgumentException("The departure date must be after the arrival date!");
        }

        if (arrivalDate.isEqual(departureDate)) {
            throw new IllegalArgumentException("You must stay for at least 1 day!");
        }

        if (guest.isEmpty()) {
            throw new IllegalArgumentException("The guest does not exist!");
        }

        if (room.isEmpty()) {
            throw new IllegalArgumentException("The room does not exist!");
        }

        // Check if room is available

        Booking booking = new Booking(UUID.randomUUID(), arrivalDate, departureDate, room.get(), guest.get());
        bookingRepository.book(booking);

        BookingCreatedEvent event = new BookingCreatedEvent(UUID.randomUUID(), arrivalDate, departureDate, room.get(), guest.get());
        eventPublisher.publishEvent(event);
    }

    @Override
    public void cancelBooking(UUID bookingId) {
        bookingRepository.cancelBooking(bookingId);
    }
}
