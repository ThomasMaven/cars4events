package eu.tomaka.controller;

import eu.tomaka.model.Car;
import eu.tomaka.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/car")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping
    public List<Car> carList() {
        return carService.findAll();
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carService.createCar(car);
    }
}
