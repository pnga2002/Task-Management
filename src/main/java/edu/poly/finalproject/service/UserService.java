package edu.poly.finalproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.poly.finalproject.entity.UserEntity;
import edu.poly.finalproject.repository.UserRepository;
@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<UserEntity> findAll() {
		return userRepository.findAll();
	}
}
