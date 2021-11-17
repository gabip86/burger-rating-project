package com.burger.springbootbackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burger.springbootbackend.exception.ResourceNotFoundException;
import com.burger.springbootbackend.model.Place;
import com.burger.springbootbackend.repository.PlaceRepository;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/")
public class PlaceController {
	
	@Autowired
	private PlaceRepository placeRepository;
	
	// get all places
	@GetMapping("/posts")
	public List<Place> getAllPlaces() {
		return placeRepository.findAll();
	}
	
	@PostMapping("/posts")
	public Place cratePlace(@RequestBody Place place) {
		return placeRepository.save(place);
	}
	
	@PutMapping("/post/{id}")
	public ResponseEntity<Place> updatePlace(@PathVariable(value="id") Long userId, @RequestBody Place placeDetails) throws Exception {
		Place place = placeRepository
				.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
		
		place.setName(placeDetails.getName());
		place.setLocation(placeDetails.getLocation());
		place.setOpeningTime(placeDetails.getOpeningTime());
		place.setTasteScore(placeDetails.getTasteScore());
		place.setTextureScore(placeDetails.getTextureScore());
		place.setPresentationScore(placeDetails.getPresentationScore());
		final Place updatedPlace = placeRepository.save(place);
		return ResponseEntity.ok(updatedPlace);
	}
	
	@DeleteMapping("/post/{id}")
	public Map<String, Boolean> deletePlace(@PathVariable(value="id") Long userId) throws Exception {
		Place place = placeRepository
				.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
		placeRepository.delete(place);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
