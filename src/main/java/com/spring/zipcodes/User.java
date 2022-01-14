package com.spring.zipcodes;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = User.TABLE)
public class User {
    public static final String TABLE = "Users";
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID", nullable = true)
    private Long id;

    private String username;

    @JsonIgnore
    private Date dateCreated;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private List<ZipCode> zipCodes;

    public User() {
        super();
        dateCreated = new Date(System.currentTimeMillis());
        this.id = 0l;
    }

    public User(String username, List<ZipCode> zipCodes){
        super();
        dateCreated = new Date(System.currentTimeMillis());
        this.id = 0l;
        this.username = username;
        this.zipCodes = zipCodes;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(username != null) {
            this.username = username;
        }
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public List<ZipCode> getZipCodes() {
        return zipCodes;
    }

    public void setZipCodes(List<ZipCode> zipCodeList) {
        this.zipCodes = zipCodeList;
    }


}
