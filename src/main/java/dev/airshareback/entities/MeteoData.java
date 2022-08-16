package dev.airshareback.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "meteo_data")
public class MeteoData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private Date datetime;

    @Column(nullable = false)
    private Float data;

    public Float getData() {
        return data;
    }

    public Date getDatetime() {
        return datetime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}