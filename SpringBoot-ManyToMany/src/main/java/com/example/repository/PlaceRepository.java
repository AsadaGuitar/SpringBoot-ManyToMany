package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.entity.Place;
import com.example.domain.entity.User;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Integer>{
	List<Place> findByUserList(User user);
}
