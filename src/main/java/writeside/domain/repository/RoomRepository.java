package writeside.domain.repository;

import writeside.domain.model.Room;

import java.util.Optional;

public interface RoomRepository {
    void create(Room room);

    Optional<Room> getRoomByNumber(String roomNumber);
}
