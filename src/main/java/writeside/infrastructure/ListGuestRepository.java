package writeside.infrastructure;

import writeside.domain.model.Guest;
import writeside.domain.repository.GuestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ListGuestRepository implements GuestRepository {
    private final List<Guest> repository = new ArrayList<>();

    @Override
    public void create(Guest guest) {
        repository.add(guest);
    }

    @Override
    public Optional<Guest> getGuestById(UUID guestId) {
        return repository
                .stream()
                .filter(guest -> guest.getGuestId().equals(guestId))
                .findFirst();
    }
}
