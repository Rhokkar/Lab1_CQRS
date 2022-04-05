package writeside.infrastructure;

import writeside.domain.model.Guest;
import writeside.domain.repository.GuestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ListGuestRepository implements GuestRepository {
    private final List<Guest> repository = List.of(
            new Guest(UUID.fromString("8ba34103-ce53-4bd9-8fb9-791373f017f5"), "Barbi"),
            new Guest(UUID.fromString("9767fbf5-7f24-4994-b5f2-e98242cb92c5"), "Chris"),
            new Guest(UUID.fromString("bbf394dc-5bf4-4be4-9419-5632d6ce1307"), "Elias")
    );

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
