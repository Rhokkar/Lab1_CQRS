package eventside.communication.rest;

import eventside.infrastructure.ListEventRepository;
import eventside.domain.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventRestController {
    @Autowired
    private ListEventRepository repository;

    @PostMapping(value = "/event", consumes = "application/json", produces = "application/json")
    public boolean addEvent(@RequestBody Event event) {
        // TODO: process event in repository
        repository.processEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }
}
