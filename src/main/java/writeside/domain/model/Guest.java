package writeside.domain.model;

import java.util.UUID;

public class Guest {
    private final UUID guestId;
    private final String name;

    public Guest(UUID guestId, String name) {
        this.guestId = guestId;
        this.name = name;
    }

    public UUID getGuestId() {
        return guestId;
    }

    public String getName() {
        return name;
    }
}
