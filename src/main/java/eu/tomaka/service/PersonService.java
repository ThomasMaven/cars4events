package eu.tomaka.service;

import eu.tomaka.model.Person;
import eu.tomaka.repo.PersonRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;

    @Transactional
    public List<Person> findAll(){
        return personRepo.findAll();
    }

    @Transactional
    public Person findOne(Long id) {
        return personRepo.findOne(id);
    }

    @Transactional
    public Person findOneByFBId(String fb_id) {
        List<Person> personList = findAll();
        for(Person person : personList) {
            if(person.getFb_id().equals(fb_id)) return person;
        }
        return null;
    }

    @Transactional
    public Person putUser(Person person) {
        Person existingPerson = findOneByFBId(person.getFb_id());
        if(existingPerson != null) {
            person.setId(existingPerson.getId());
            BeanUtils.copyProperties(person, existingPerson);
            return personRepo.saveAndFlush(existingPerson);
        }
        return personRepo.saveAndFlush(person);
    }

}
