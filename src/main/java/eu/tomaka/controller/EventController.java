package eu.tomaka.controller;

import eu.tomaka.model.Event;
import eu.tomaka.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class EventController {
    @Autowired
    EventService eventService;

    @GetMapping
    private List<Event> eventList() {
        return eventService.findAll();
    }

    @RequestMapping(value = "event", method = RequestMethod.POST)
    public Event createPerson(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

}
