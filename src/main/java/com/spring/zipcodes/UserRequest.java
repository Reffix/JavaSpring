package com.spring.zipcodes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

public class UserRequest {
    @JsonProperty("username")
    private String username;
    @JsonProperty("zipCodes")
    private Long[] zipCodes;

    public UserRequest(){
        super();
    }

    public UserRequest(String username, Long[] zipCodeList){
        super();
        this.username = username;
        this.zipCodes = Arrays.copyOf(zipCodeList, zipCodeList.length);
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long[] getZipCodeList() {
        return zipCodes;
    }

    public void setZipCodeList(Long[] zipCodeList) {
        this.zipCodes = Arrays.copyOf(zipCodeList, zipCodeList.length);
    }
}
