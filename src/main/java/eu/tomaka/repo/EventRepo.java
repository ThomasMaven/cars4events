package eu.tomaka.repo;

import eu.tomaka.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepo extends JpaRepository<Event, Long> {
}
