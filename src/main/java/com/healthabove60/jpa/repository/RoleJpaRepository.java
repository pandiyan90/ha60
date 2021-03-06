package com.healthabove60.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthabove60.jpa.entity.Role;

@Repository
public interface RoleJpaRepository extends JpaRepository<Role, Integer>{
	
	public Role findByRole(String roleName, Boolean isActive, Boolean isDeleted);

}