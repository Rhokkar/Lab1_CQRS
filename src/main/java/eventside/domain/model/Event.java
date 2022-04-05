package eventside.domain.model;

import java.time.LocalDateTime;

public abstract class Event {
    private final LocalDateTime timestamp = LocalDateTime.now();

    @Override
    public String toString() {
        return "Event{" +
                "timestamp=" + timestamp +
                '}';
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
