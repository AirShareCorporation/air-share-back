package dev.airshareback.entities;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "census_data")
public class CensusData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "data_census")
    private int dataCensus;

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date_census) {
        this.date = date_census;
    }

    public int getDataCensus() {
        return dataCensus;
    }

    public void setDataCensus(int data_census) {
        this.dataCensus = data_census;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}