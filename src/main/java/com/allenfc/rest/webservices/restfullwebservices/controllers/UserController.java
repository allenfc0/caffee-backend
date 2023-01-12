package com.allenfc.rest.webservices.restfullwebservices.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.allenfc.rest.webservices.restfullwebservices.models.User;
import com.allenfc.rest.webservices.restfullwebservices.services.UserService;

@RestController
@CrossOrigin(origins="*", maxAge=3600, allowedHeaders="content-type:application.json")
public class UserController { 
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path="/api/users-list")
	public Iterable<User> getAllJobs() {
		return userService.findAll();
	}
	
	@GetMapping(path="/api/users/{id}") 
	public User getUserById(@PathVariable Long id) {
		return userService.findUserById(id);
	}
	
	//used for logging in
	@GetMapping(path="/api/users/username/{username}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
		System.out.println("\n\n\n\n" +username+"----------------------------------------------------------");
		return new ResponseEntity<>(userService.findUserByUsername(username), HttpStatus.OK);
	}
	
	@DeleteMapping(path="/api/users/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path="/api/users/update/{id}")
	public ResponseEntity<User> updateUser(
			@PathVariable Long id,
			@RequestBody User user) {
		User updatedUser = userService.saveUser(user);
		
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	}
	
	@PostMapping(path="/api/users/create") 
	public ResponseEntity<Void> createdUser (
			@RequestBody User user) {
		user.setId(userService.getNextAvailableId());
		User createdUser = userService.saveUser(user);
			
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
}







