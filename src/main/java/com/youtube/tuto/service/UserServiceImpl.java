package com.youtube.tuto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.tuto.dao.UserRepository;
import com.youtube.tuto.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	protected UserRepository userRepository;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

}
