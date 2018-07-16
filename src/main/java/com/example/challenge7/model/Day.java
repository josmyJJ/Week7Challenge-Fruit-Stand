package com.example.challenge7.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "days")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "day_id")
    private long dayId;

    @Column(name = "day_name")
    private String dayName;

    @OneToMany(mappedBy = "day",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    private Set<Fruit> fruits;

    public long getDayId() {
        return dayId;
    }

    public void setDayId(long dayId) {
        this.dayId = dayId;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public Set<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(Set<Fruit> fruits) {
        this.fruits = fruits;
    }

}
