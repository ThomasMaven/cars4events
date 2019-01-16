package eu.tomaka.controller;

import eu.tomaka.model.SeatSchema;
import eu.tomaka.service.SeatSchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/seat_schema")
public class SeatSchemaController {
    @Autowired
    SeatSchemaService seatSchemaService;

    @GetMapping
    public List<SeatSchema> seatSchemaList() {
        return seatSchemaService.findAll();
    }

    @PostMapping
    public SeatSchema createSeatSchema(@RequestBody SeatSchema seatSchema) {
        return seatSchemaService.createSeatSchemat(seatSchema);
    }
}
