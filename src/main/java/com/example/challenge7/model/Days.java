package com.example.challenge7.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Days {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long dayId;

    private String dayname;

//    @OneToMany(mappedBy = "days",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER,
//            orphanRemoval = true)
//    private Set<Fruits> fruits;




    public long getDayId() {
        return dayId;
    }

    public void setDayId(long dayId) {
        this.dayId = dayId;
    }



    public String getDayname() {
        return dayname;
    }

    public void setDayname(String dayname) {
        this.dayname = dayname;
    }

//    public Set<Fruits> getFruits() {
//        return fruits;
//    }
//
//    public void setFruits(Set<Fruits> fruits) {
//        this.fruits = fruits;
//    }

}
