package eu.tomaka.service;

import eu.tomaka.model.Event;
import eu.tomaka.model.Person;
import eu.tomaka.repo.EventRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepo eventRepo;

    @Transactional
    public List<Event> findAll() {
        return eventRepo.findAll();
    }

    @Transactional
    public Event findOne(Long id) {
        return eventRepo.findOne(id);
    }

    @Transactional
    public Event createEvent(Event event) {
        return eventRepo.saveAndFlush(event);
    }
    @Transactional
    public Event deleteEvent(Long id) {
        Event eventToDel = eventRepo.findOne(id);
        eventRepo.delete(eventToDel);
        return eventToDel;
    }

    @Transactional
    public Event updateEvent(Long id, Event event) {
        Event existingEvent = eventRepo.findOne(id);
        BeanUtils.copyProperties(event, existingEvent);
        return eventRepo.saveAndFlush(existingEvent);
    }

    @Transactional
    public Event addPerson(Long id, Person person) {
        Event existingEvent = eventRepo.findOne(id);
        List<Person> updatedPersonList = existingEvent.getPersonList();
        updatedPersonList.add(person);
        existingEvent.setPersonList(updatedPersonList);
        return eventRepo.saveAndFlush(existingEvent);
    }

}
