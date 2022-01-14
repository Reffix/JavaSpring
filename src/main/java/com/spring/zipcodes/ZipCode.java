package com.spring.zipcodes;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = ZipCode.TABLE)
public class ZipCode {
    public static final String TABLE = "ZipCode";

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long zipCode;

    private String placeName;
    private String longitude;
    private String latitude;

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public ZipCode() {
        super();
        this.id = 0l;
    }

    public ZipCode(Long zipCode){
        super();
        this.zipCode = zipCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public boolean equals(Object other){
        if(this == other){
            return true;
        }
        if(!(other instanceof ZipCode)){
            return false;
        }

        ZipCode zipCode = (ZipCode) other;

        return (this.zipCode.equals(zipCode.zipCode));
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;
}
