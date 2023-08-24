package com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpal implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}

	@Override
	public User getUserById(int userId) {
		List<User> users = userRepository.findAll();
		Optional<User> user = users.stream().filter(u -> u.getId() == userId).findFirst();
		return user.isPresent() ? user.get() : null;
	}

	@Override
	public User findUserProfileById(int userId) {
		User user = getUserById(userId);
		return user;
	}
	
	
}
