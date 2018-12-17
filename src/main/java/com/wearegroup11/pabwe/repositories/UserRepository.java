package com.wearegroup11.pabwe.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wearegroup11.pabwe.models.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
	
	Optional<User> findById(Long id);
}
