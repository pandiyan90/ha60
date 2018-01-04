package com.healthabove60.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.healthabove60.dto.UserDTO;
import com.healthabove60.jpa.entity.Role;
import com.healthabove60.jpa.entity.User;
import com.healthabove60.jpa.repository.RoleJpaRepository;
import com.healthabove60.jpa.repository.UserJpaRepository;
import com.healthabove60.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService{

	@Autowired
	private UserJpaRepository userJpaRepository;

	@Autowired
	private RoleJpaRepository roleJpaRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder; 
	
	@Override
	public User createNewUser(UserDTO userDTO) {
		User user = new User();
		user.setName(userDTO.getName());
		user.setUserId(userDTO.getEmail());
		user.setIsActive(true);
		user.setIsDeleted(false);
		user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
		Role role = roleJpaRepository.findByRole("ADMIN", true, false);
		user.setRoles(new HashSet<Role>(Arrays.asList(role)));
		userJpaRepository.save(user);
		return user;
	}

	@Override
	public User findUser(String userId) {
		return userJpaRepository.findByUserId(userId);
	}

	@Override
	public List<User> findAllUsers() {
		List<User> list = userJpaRepository.findAll();
		log.info("list: "+list);
		return list;
	}

}