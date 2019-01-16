package eu.tomaka.controller;

import eu.tomaka.model.Person;
import eu.tomaka.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("person")
    public List<Person> personList() {
        return personService.findAll();
    }

    @RequestMapping(value = "person", method = RequestMethod.PUT)
    public Person putPerson(@RequestBody Person person) {
        return personService.putPerson(person);
    }

    @RequestMapping(value = "person/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable Long id) {
        return personService.findOne(id);
    }

}
