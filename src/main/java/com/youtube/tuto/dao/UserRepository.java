package com.youtube.tuto.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youtube.tuto.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@SuppressWarnings("unchecked")
	public User save(User user);
	
	@SuppressWarnings("unchecked")
	public List<User> findAll();
}
