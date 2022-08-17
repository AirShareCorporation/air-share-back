package dev.airshareback.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "meteo_data")
public class MeteoData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private Date date_meteo;

    @Column(nullable = false)
    private Float data_meteo;

    public MeteoData() {
    }

    public Float getData_meteo() {
        return data_meteo;
    }

    public Date getDate_meteo() {
        return date_meteo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate_meteo(Date date_meteo) {
        this.date_meteo = date_meteo;
    }

    public void setData_meteo(Float data_meteo) {
        this.data_meteo = data_meteo;
    }

}