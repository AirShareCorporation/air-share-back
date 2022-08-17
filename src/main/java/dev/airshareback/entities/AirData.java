package dev.airshareback.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "air_data")
public class AirData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date_aire")
    private LocalDate date_aire;

    @Column(name = "data_aire")
    private int data_aire;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    public AirData() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate_aire() {
        return date_aire;
    }

    public void setDate_aire(LocalDate date_aire) {
        this.date_aire = date_aire;
    }

    public int getData_aire() {
        return data_aire;
    }

    public void setData_aire(int data_aire) {
        this.data_aire = data_aire;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
