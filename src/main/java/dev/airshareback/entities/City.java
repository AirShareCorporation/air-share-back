package dev.airshareback.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "departement_code", length = 255, nullable = false)
    private String departement_code;

    @Column(name = "insee_code", length = 15, nullable = false)
    private String insee_code;

    @Column(name = "zip_code", length = 5, nullable = false)
    private String zip_code;

    @Column(name = "name", length = 60, nullable = false)
    private String name;

    @Column(name = "slug", length = 60, nullable = false)
    private String slug;

    @Column(name = "gps_lat", nullable = false)
    private long gps_lat;

    @Column(name = "gps_lng", nullable = false)
    private long gps_lng;

    @OneToMany
    private List<Address> listAdresses = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "departement_id", nullable = false)
    private Departement departement;

    @OneToMany(mappedBy = "city", orphanRemoval = true)
    private List<MeteoData> meteoDatas = new ArrayList<>();

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

    public String getDepartement_code() {
        return departement_code;
    }

    public void setDepartement_code(String departement_code) {
        this.departement_code = departement_code;
    }

    public String getInsee_code() {
        return insee_code;
    }

    public void setInsee_code(String insee_code) {
        this.insee_code = insee_code;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
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

    public long getGps_lat() {
        return gps_lat;
    }

    public void setGps_lat(long gps_lat) {
        this.gps_lat = gps_lat;
    }

    public long getGps_lng() {
        return gps_lng;
    }

    public void setGps_lng(long gps_lng) {
        this.gps_lng = gps_lng;
    }

    public List<Address> getListAdresses() {
        return listAdresses;
    }

    public void setListAdresses(List<Address> listAdresses) {
        this.listAdresses = listAdresses;
    }

}
