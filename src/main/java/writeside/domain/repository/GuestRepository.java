package writeside.domain.repository;

import writeside.domain.model.Guest;

import java.util.Optional;
import java.util.UUID;

public interface GuestRepository {
    void create(Guest guest);

    Optional<Guest> getGuestById(UUID guestId);
}