package com.wearegroup11.pabwe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wearegroup11.pabwe.models.Role;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByRole(String role);
}
