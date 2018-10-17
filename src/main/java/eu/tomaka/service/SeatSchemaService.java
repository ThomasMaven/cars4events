package eu.tomaka.service;

import eu.tomaka.model.SeatSchema;
import eu.tomaka.repo.SeatSchemaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SeatSchemaService {
    @Autowired
    private SeatSchemaRepo seatSchemaRepo;

    @Transactional
    public List<SeatSchema> findAll() {
        return seatSchemaRepo.findAll();
    }

    @Transactional
    public SeatSchema findOne(Long id) {
        return seatSchemaRepo.findOne(id);
    }

    @Transactional
    public SeatSchema createSeatSchemat(SeatSchema seatSchema) {
        return seatSchemaRepo.saveAndFlush(seatSchema);
    }
}
