package eu.tomaka.service;


import eu.tomaka.model.Car;
import eu.tomaka.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepo carRepo;

    @Transactional
    public List<Car> findAll() {

        return carRepo.findAll();
    }

    @Transactional
    public Car findOne(Long id) {

        return carRepo.findOne(id);
    }

    @Transactional
    public Car createCar(Car car) {

        return carRepo.saveAndFlush(car);
    }
}
