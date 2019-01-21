package eu.tomaka.controller;

import eu.tomaka.model.Car;
import eu.tomaka.model.Event;
import eu.tomaka.model.Person;
import eu.tomaka.model.SeatSchema;
import eu.tomaka.repo.EventRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AnotherEventControllerTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    EventController eventController;

    @Autowired
    EventRepo repo;


    @Test
    @Rollback
    public void name() {
        Event testEvent = new Event();

        Person person = new Person();
        Car car = new Car();
        SeatSchema schema = new SeatSchema();

        car.setSeatSchema(schema);
        testEvent.setOwner(person);
        testEvent.setCar(car);

        Event event = eventController.createEvent(testEvent);

        Assert.assertNotNull(repo.getOne(event.getId()));


    }
}