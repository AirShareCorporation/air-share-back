package dev.airshareback.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "meteo_data")
public class MeteoData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn
    private City city;

    @Column(name = "wind_10_m")
    private Integer wind10m;

    @Column(name = "gust_10_m")
    private Integer gust10m;

    @Column(name = "dirwind_10_m")
    private Integer dirwind10m;

    @Column(name = "rr_10")
    private Float rr10;

    @Column(name = "rr_1")
    private Float rr1;

    @Column(name = "probarain")
    private Integer probarain;

    @Column(name = "weather")
    private Integer weather;

    @Column(name = "tmin")
    private Integer tmin;

    @Column(name = "tmax")
    private Integer tmax;

    @Column(name = "sun_hours")
    private Integer sunHours;

    @Column(name = "etp")
    private Integer etp;

    @Column(name = "probafrost")
    private Integer probafrost;

    @Column(name = "probafog")
    private Integer probafog;

    @Column(name = "probawind_70")
    private Integer probawind70;

    @Column(name = "probawind_100")
    private Integer probawind100;

    @Column(name = "gustx")
    private Integer gustx;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getGustx() {
        return gustx;
    }

    public void setGustx(Integer gustx) {
        this.gustx = gustx;
    }

    public Integer getProbawind100() {
        return probawind100;
    }

    public void setProbawind100(Integer probawind100) {
        this.probawind100 = probawind100;
    }

    public Integer getProbawind70() {
        return probawind70;
    }

    public void setProbawind70(Integer probawind70) {
        this.probawind70 = probawind70;
    }

    public Integer getProbafog() {
        return probafog;
    }

    public void setProbafog(Integer probafog) {
        this.probafog = probafog;
    }

    public Integer getProbafrost() {
        return probafrost;
    }

    public void setProbafrost(Integer probafrost) {
        this.probafrost = probafrost;
    }

    public Integer getEtp() {
        return etp;
    }

    public void setEtp(Integer etp) {
        this.etp = etp;
    }

    public Integer getSunHours() {
        return sunHours;
    }

    public void setSunHours(Integer sunHours) {
        this.sunHours = sunHours;
    }

    public Integer getTmax() {
        return tmax;
    }

    public void setTmax(Integer tmax) {
        this.tmax = tmax;
    }

    public Integer getTmin() {
        return tmin;
    }

    public void setTmin(Integer tmin) {
        this.tmin = tmin;
    }

    public Integer getWeather() {
        return weather;
    }

    public void setWeather(Integer weather) {
        this.weather = weather;
    }

    public Integer getProbarain() {
        return probarain;
    }

    public void setProbarain(Integer probarain) {
        this.probarain = probarain;
    }

    public Float getRr1() {
        return rr1;
    }

    public void setRr1(Float rr1) {
        this.rr1 = rr1;
    }

    public Float getRr10() {
        return rr10;
    }

    public void setRr10(Float rr10) {
        this.rr10 = rr10;
    }

    public Integer getDirwind10m() {
        return dirwind10m;
    }

    public void setDirwind10m(Integer dirwind10m) {
        this.dirwind10m = dirwind10m;
    }

    public Integer getGust10m() {
        return gust10m;
    }

    public void setGust10m(Integer gust10m) {
        this.gust10m = gust10m;
    }

    public Integer getWind10m() {
        return wind10m;
    }

    public void setWind10m(Integer wind10m) {
        this.wind10m = wind10m;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public MeteoData() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}