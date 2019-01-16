package eu.tomaka.repo;

import eu.tomaka.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepo extends JpaRepository<Person, Long> {
    Optional<Person> findByFbid(String fbid);

    @Query("select p from Person p where p.email like '%xxx%'")
    List<Person> whatever();
}
