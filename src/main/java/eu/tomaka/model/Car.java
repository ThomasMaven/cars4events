package eu.tomaka.model;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    //TODO: set constraints
    @ManyToOne
    private SeatSchema seatSchema;
}
