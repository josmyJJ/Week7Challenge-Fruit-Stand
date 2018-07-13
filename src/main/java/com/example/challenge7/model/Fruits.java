package com.example.challenge7.model;

import javax.persistence.*;

@Entity
public class Fruits {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String furitname;

    private String day;

    private String img;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFuritname() {
        return furitname;
    }

    public void setFuritname(String furitname) {
        this.furitname = furitname;
    }


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
