package dev.entities;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name_rubrique", nullable = false)
    private String name_rubrique;

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_rubrique() {
        return name_rubrique;
    }

    public void setName_rubrique(String name_rubrique) {
        this.name_rubrique = name_rubrique;
    }
}
