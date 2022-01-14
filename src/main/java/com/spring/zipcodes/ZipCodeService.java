package com.spring.zipcodes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZipCodeService {
    private ZipCodeRepository zipCodeRepository;

    public List<ZipCode> getZipCodeById(Long id){
        return zipCodeRepository.findAllByUser(id);
    }

}
