package com.subscreasy.service;

import java.util.List;

import com.subscreasy.model.User;

public interface UserService {
	
	User save(User user);

	List<User> findAll();

	User getUserByEmail(String email);

}
