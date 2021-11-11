package com.burger.springbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.burger.springbootbackend.model.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

}
