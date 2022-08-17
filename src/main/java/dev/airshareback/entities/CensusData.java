package dev.airshareback.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "census_data")
public class CensusData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date_meteo")
    private LocalDate date_census;

    @Column(name = "data_meteo")
    private int data_census;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    public CensusData() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate_census() {
        return date_census;
    }

    public void setDate_census(LocalDate date_census) {
        this.date_census = date_census;
    }

    public int getData_census() {
        return data_census;
    }

    public void setData_census(int data_census) {
        this.data_census = data_census;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
