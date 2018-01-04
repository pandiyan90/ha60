package com.healthabove60.service;

import java.util.List;

import com.healthabove60.dto.UserDTO;
import com.healthabove60.jpa.entity.User;

public interface UserService {

	public User findUser(String userId);

	public User createNewUser(UserDTO userDTO);

	public List<User> findAllUsers();

}