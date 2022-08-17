package dev.airshareback.entities;

import javax.persistence.*;

@Entity
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Embedded
    private Pm10 pm10;
    @Embedded
    private Pm25 pm25;
    @Embedded
    private N02 n02;
    @Embedded
    private P p;
    @Embedded
    private T T;
    @Embedded
    private W w;
    @Embedded
    private Wg wg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
