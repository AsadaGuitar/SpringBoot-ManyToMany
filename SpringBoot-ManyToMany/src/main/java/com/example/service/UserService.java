package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public Optional<User> findOne(Integer id) {
		return userRepository.findById(id);
	}
	
	public User create(User user) {
		return userRepository.save(user);
	}
	
	public User findOneByMark(Integer id) {
		return userRepository.findOneByMark(id);
	}
	
	public User update(User user) {
		return userRepository.save(user);
	}
}
