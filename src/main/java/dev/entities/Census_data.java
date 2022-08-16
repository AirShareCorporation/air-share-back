package dev.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "census_data")
public class Census_data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date_meteo")
    private LocalDate date_meteo;

    @Column(name = "data_meteo")
    private int data_meteo;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    public Census_data() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate_meteo() {
        return date_meteo;
    }

    public void setDate_meteo(LocalDate date_meteo) {
        this.date_meteo = date_meteo;
    }

    public int getData_meteo() {
        return data_meteo;
    }

    public void setData_meteo(int data_meteo) {
        this.data_meteo = data_meteo;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
