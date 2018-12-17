package com.wearegroup11.pabwe.services;

import java.util.Optional;

import com.wearegroup11.pabwe.models.User;

public interface UserService {
	
	void save(User user);

	User findByEmail(String email);
	
	Optional<User> findById(Long id);
}
