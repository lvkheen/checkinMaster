package com.lvkheen.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "This field is required")
    @Pattern(regexp = "[A-Za-z]+", message = "Incorrect city")
    @Column(name = "city")
    private String city;

    @NotNull(message = "This field is required")
    @Column(name = "place")
    private String place;

    @NotNull(message = "This field is required")
    @Pattern(regexp = "[\\w]+", message = "Incorrect name")
    @Column(name = "visitor_name")
    private String visitorName;

    @NotNull(message = "This field is required")
    @Min(value = 1, message = "rate from 1 to 5")
    @Max(value = 5, message = "rate from 1 to 5")
    @Column(name = "rating")
    private Integer rating;

    @Column(name = "comment")
    private String comment;

    public Location() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
