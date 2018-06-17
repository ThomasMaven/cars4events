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
    public Person putUser(Person person) {
        Person existingPerson = personRepo.findByFbid(person.getFbid()).orElse(null);
        if (existingPerson != null) {
            person.setId(existingPerson.getId());
            BeanUtils.copyProperties(person, existingPerson);
            return personRepo.saveAndFlush(existingPerson);
        }
        return personRepo.saveAndFlush(person);
    }

}
