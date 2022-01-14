package com.spring.zipcodes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;


@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getUser/id/{id}")
    public User getUserById(@PathVariable Long id){
        return userRepository.getUserById(id);
    }

    @PostMapping("/saveUser")
    public User saveUserById(@RequestBody UserRequest userRequest){

        List<ZipCode> zipCodes = new ArrayList<>(userRequest.getZipCodeList().length);

        for (int i = 0 ; i < userRequest.getZipCodeList().length; i++) {
            ZipCode tmp = new ZipCode(userRequest.getZipCodeList()[i]);
            zipCodes.add(i, tmp);
        }

        User requestUser = new User(userRequest.getUsername(), zipCodes);

        for (ZipCode zipCode: requestUser.getZipCodes()){
            Address address = AddressController.getAddress(zipCode.getZipCode());

            zipCode.setPlaceName(address.getPlaces()[0].getPlaceName());
            zipCode.setLatitude(address.getPlaces()[0].getLatitude());
            zipCode.setLongitude(address.getPlaces()[0].getLatitude());
            zipCode.setUser(requestUser);
        }

        return userRepository.save(requestUser);
    }

    @GetMapping("/getUser/username/{username}")
    public User getUserByUsername(@PathVariable String username){

       List<User> userList = userRepository.getAllByUsername(username);

       User responseUser = userList.get(0);
       for (User user: userList){
           responseUser.getZipCodes().addAll(user.getZipCodes());
       }
       responseUser.setZipCodes(responseUser.getZipCodes().stream().distinct().collect(Collectors.toList()));

       return responseUser;
    }

    @GetMapping("/getUser/latestRegistration/{username}")
    public User getLastestRegistration(@PathVariable String username){
        List<User> userList= userRepository.getAllByUsername(username);

        User responseUser = Collections.max(userList, Comparator.comparing(user -> user.getDateCreated()));

        return responseUser;
    }

}
