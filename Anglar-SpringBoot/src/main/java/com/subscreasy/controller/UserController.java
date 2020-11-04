package com.subscreasy.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subscreasy.model.User;
import com.subscreasy.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String home() {
	    System.out.println("Hello Home...");
	    return "home.json";
	}
	
	@GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userService.findAll();
    }
		
	
	@RequestMapping({ "/getuser" })
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<User> getUser(Principal principal) {
		User user = userService.getUserByEmail(principal.getName());
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	

}
