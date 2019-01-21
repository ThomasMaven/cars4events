package eu.tomaka;

import eu.tomaka.model.Event;
import eu.tomaka.model.Person;

import java.util.ArrayList;
import java.util.List;

public class TestEvents {

    public List<Event> getEvents(int size) {
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Event tmpEvent = new Event();
            tmpEvent.setDeparture("01.01.2018");
            tmpEvent.setBack("02.01.2018");
            tmpEvent.setPersonList(getMockedPersonList());
            events.add(tmpEvent);
        }

        return events;
    }

    public List<Person> getMockedPersonList() {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Person person = new Person("name" + i, "surname" + i, "00" + i, i + "@example.com");
            personList.add(person);
        }
        return personList;
    }
}