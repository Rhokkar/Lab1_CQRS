package writeside.infrastructure;

import writeside.domain.model.Room;
import writeside.domain.repository.RoomRepository;

import java.util.*;

public class ListRoomRepository implements RoomRepository {
    private final List<Room> repository = List.of(new Room("101"), new Room("102"), new Room("103"), new Room("104"));

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