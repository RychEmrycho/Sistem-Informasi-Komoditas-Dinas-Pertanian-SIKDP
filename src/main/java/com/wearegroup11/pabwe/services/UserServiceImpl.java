package com.wearegroup11.pabwe.services;

import com.wearegroup11.pabwe.models.Role;
import com.wearegroup11.pabwe.models.User;
import com.wearegroup11.pabwe.repositories.RoleRepository;
import com.wearegroup11.pabwe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        // TODO Auto-generated method stub
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//		user.setActive(1);

        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        // TODO Auto-generated method stub
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findById(Long id) {
        // TODO Auto-generated method stub
        return userRepository.findById(id);
    }
}
