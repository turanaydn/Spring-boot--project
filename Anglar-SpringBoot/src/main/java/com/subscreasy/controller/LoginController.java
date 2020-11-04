package com.subscreasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.subscreasy.domain.Response;
import com.subscreasy.model.User;
import com.subscreasy.service.UserService;

@RestController
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/registration")
	public ResponseEntity<Response> registration(@RequestBody User user) {
		User dbUser = userService.save(user);
		if(dbUser!=null) {
			return new ResponseEntity<Response>(new Response("User is save successfully"), HttpStatus.OK);
		}
		return null;
	}

}
