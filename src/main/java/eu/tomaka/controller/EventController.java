package eu.tomaka.controller;

import eu.tomaka.model.Event;
import eu.tomaka.model.Person;
import eu.tomaka.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/event")
public class EventController {
    @Autowired
    EventService eventService;

    @GetMapping
    private List<Event> eventList() {
        return eventService.findAll();
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @PostMapping(value = "{id}/addPerson")
    public Event addPerson(@PathVariable Long id, @RequestBody Person person) {
        return eventService.addPerson(id, person);
    }
}
