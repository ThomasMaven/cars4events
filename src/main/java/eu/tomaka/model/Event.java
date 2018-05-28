package eu.tomaka.model;

import javax.persistence.*;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long owner_id;
    //TODO: add user list
    private Long car_id;
    private String departure;
    private String back;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }
}
