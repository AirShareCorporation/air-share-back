package dev.airshareback.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "departement_code", length = 255, nullable = false)
    private String departementCode;

    @Column(name = "insee_code", length = 15, nullable = false)
    private String inseeCode;

    @Column(name = "zip_code", length = 5)
    private String zipCode;

    @Column(name = "name", length = 60, nullable = false)
    private String name;

    @Column(name = "slug", length = 60, nullable = false)
    private String slug;

    @Column(name = "gps_lat")
    private Double gpsLat;

    @Column(name = "gps_lng")
    private Double gpsLng;


    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Departement departement;

    @OneToMany(mappedBy = "city", orphanRemoval = true)
    @JsonIgnore
    private List<MeteoData> meteoDatas = new ArrayList<>();

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Address> addresses = new ArrayList<>();

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<MeteoData> getMeteoDatas() {
        return meteoDatas;
    }

    public void setMeteoDatas(List<MeteoData> meteoDatas) {
        this.meteoDatas = meteoDatas;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public City() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartementCode() {
        return departementCode;
    }

    public void setDepartementCode(String departement_code) {
        this.departementCode = departement_code;
    }

    public String getInseeCode() {
        return inseeCode;
    }

    public void setInseeCode(String insee_code) {
        this.inseeCode = insee_code;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zip_code) {
        this.zipCode = zip_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Double getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(Double gps_lat) {
        this.gpsLat = gps_lat;
    }

    public Double getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(Double gps_lng) {
        this.gpsLng = gps_lng;
    }

}
