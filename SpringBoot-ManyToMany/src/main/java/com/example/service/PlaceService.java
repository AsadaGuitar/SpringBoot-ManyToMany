package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.entity.Place;
import com.example.domain.entity.User;
import com.example.repository.PlaceRepository;

@Service
public class PlaceService {

	@Autowired
	PlaceRepository placeRepository;
	
	public Optional<Place> findOne(Integer id){
		return placeRepository.findById(id);
	}
	
	public Place create(Place place) {
		return placeRepository.save(place);
	}
	
	public List<Place> findByUsers(User user){
		return placeRepository.findByUserList(user);
	}
}
