package dev.airshareback.entities;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Entity
@Embeddable
public class O3 {
    public int v;
    public int avg;
    public String day;
    public int max;
    public int min;
}
