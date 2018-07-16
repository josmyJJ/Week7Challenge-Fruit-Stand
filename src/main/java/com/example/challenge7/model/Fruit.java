package com.example.challenge7.model;

import javax.persistence.*;

@Entity
@Table(name = "fruits")
public class Fruit {

    public  Fruit() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fruit_id")
    private long myId;

    @Column(name = "fruit_name")
    private String fruitName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "day_id", nullable = false)
    private Day day;

    private String image;

    public long getMyId() {
        return myId;
    }

    public void setMyId(long myid) {
        this.myId = myid;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }


    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
