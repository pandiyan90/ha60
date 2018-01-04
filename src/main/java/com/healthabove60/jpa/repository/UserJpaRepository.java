package com.healthabove60.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthabove60.jpa.entity.User;

public interface UserJpaRepository extends JpaRepository<User, String>{

	public User findByUserId(String userId);

}