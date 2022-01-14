package com.spring.zipcodes;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZipCodeRepository extends JpaRepository<ZipCode, Long> {
    ZipCode getZipCodeById(Long id);

    @EntityGraph(value = "ZipCode.user", type = EntityGraph.EntityGraphType.FETCH)
    List<ZipCode> findAllByUser(Long id);
}
