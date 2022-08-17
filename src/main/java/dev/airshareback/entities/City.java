package dev.airshareback.entities;

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

    @Column(name = "zip_code", length = 5, nullable = false)
    private String zipCode;

    @Column(name = "name", length = 60, nullable = false)
    private String name;

    @Column(name = "slug", length = 60, nullable = false)
    private String slug;

    @Column(name = "gps_lat", nullable = false)
    private long gpsLat;

    @Column(name = "gps_lng", nullable = false)
    private long gpsLng;



    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "departement_id", nullable = false)
    private Departement departement;

    @OneToMany(mappedBy = "city", orphanRemoval = true)
    private List<MeteoData> meteoDatas = new ArrayList<>();

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
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

    public long getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(long gps_lat) {
        this.gpsLat = gps_lat;
    }

    public long getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(long gps_lng) {
        this.gpsLng = gps_lng;
    }

}
