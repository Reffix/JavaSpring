package com.spring.zipcodes;

import org.springframework.web.client.RestTemplate;

public class AddressController {
    public static Address getAddress(Long zipCode){
        final String url = "https://api.zippopotam.us/us/";

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url + zipCode, Address.class);
    }
}
