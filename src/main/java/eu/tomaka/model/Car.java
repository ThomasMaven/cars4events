package eu.tomaka.model;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    @ManyToOne
    private SeatSchema seatSchema;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public SeatSchema getSeatSchema() {
        return seatSchema;
    }

    public void setSeatSchema(SeatSchema seatSchema) {
        this.seatSchema = seatSchema;
    }
}
