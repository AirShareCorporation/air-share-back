package dev.airshareback.entities;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 10)
    private String building;

    @Column(nullable = false)
    private String street;

    private String additionnal;

    @ManyToOne(optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public String getAdditionnal() {
        return additionnal;
    }

    public String getBuilding() {
        return building;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setAdditionnal(String additionnal) {
        this.additionnal = additionnal;
    }


}