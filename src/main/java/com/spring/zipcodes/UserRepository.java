package com.spring.zipcodes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserById(Long id);
    User getByUsername(String username);
    List<User> getAllByUsername(String username);
    //User getByUsernameAnd
}
