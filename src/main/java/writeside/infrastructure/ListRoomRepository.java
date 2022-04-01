package writeside.infrastructure;

import writeside.domain.model.Room;
import writeside.domain.repository.RoomRepository;

import java.util.*;

public class ListRoomRepository implements RoomRepository {
    private final List<Room> repository = new ArrayList<>();

    @Override
    public void create(Room room) {
        repository.add(room);
    }

    @Override
    public Optional<Room> getRoomByNumber(String roomNumber) {
        return repository
                .stream()
                .filter(room -> room.getRoomNumber().equals(roomNumber))
                .findFirst();
    }
}