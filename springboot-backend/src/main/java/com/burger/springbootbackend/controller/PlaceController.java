package com.burger.springbootbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burger.springbootbackend.model.Place;
import com.burger.springbootbackend.repository.PlaceRepository;

@RestController
@RequestMapping("/api/v1/")
public class PlaceController {
	
	@Autowired
	private PlaceRepository placeRepository;
	
	// get all places
	@GetMapping("/places")
	public List<Place> getAllPlaces() {
		return placeRepository.findAll();
	}
}
