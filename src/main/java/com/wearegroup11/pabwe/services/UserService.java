package com.wearegroup11.pabwe.services;

import com.wearegroup11.pabwe.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> listUser();

	void save(User user);

    void updateStatus(User user);

	User findByEmail(String email);

    Optional<User> findById(Long id);
}
