package com.allenfc.rest.webservices.restfullwebservices.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/*import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;*/
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.allenfc.rest.webservices.restfullwebservices.models.User;
import com.allenfc.rest.webservices.restfullwebservices.services.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200", maxAge=3600, allowedHeaders="content-type:application.json")
public class SecureAuthController {
	
	@Autowired
	private UserService service;
	
	/*
	 * @Autowired private AuthenticationManager authenticationManager;
	 * 
	 * @PostMapping(path="/signin") public ResponseEntity<String>
	 * authenticateUser(@RequestBody User user) { Authentication authentication =
	 * authenticationManager.authenticate( new
	 * UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	 * 
	 * SecurityContextHolder.getContext().setAuthentication(authentication);
	 * 
	 * return new ResponseEntity<>("Successful Login!", HttpStatus.OK); }
	 */
	
	//This basicAuth method is for testing basic login with no token or security
	@GetMapping(path="/basicAuth/{username}/{password}")
	public ResponseEntity<BasicAuthentication> authenticationNoToken(@PathVariable String username, @PathVariable String password) {
		BasicAuthentication code = new BasicAuthentication(400);
		
		try {
			User foundUser = service.findUserByUsername(username);
			
			if(foundUser.getPassword().equals(password)) {
				code.setStatus(200);
				code.setMessage("Successful Sign In!");
			} else {
				code.setMessage("Invalid Credentials!");
			}
			
		} catch(Exception e) {
			System.out.println("\nException: " + e);
		}
		
		return new ResponseEntity<BasicAuthentication>(code, HttpStatus.OK);
	}
	
	@GetMapping(path="/tokenAuth/{username}/{password}")
	public ResponseEntity<BasicAuthentication> authenticationWithToken(@PathVariable String username, @PathVariable String password) {
		BasicAuthentication code = new BasicAuthentication(100);
		//get 'normal' String username and password from token
		//String username = this.convertAsciiToUsername(token);
		//String password = this.convertAsciiToPassword(token);
		
		//check if username and password are found and match
			//set code 200 for successful login
			//set code 400 for unsuccessful login
		BCryptEncoder encoder = new BCryptEncoder();
		try {
			//Look up using JPA services. Will Use Authentication
			User foundUser = service.findUserByUsername(username);
			if(encoder.checkPassword(password, foundUser.getPassword())) {
				code.setStatus(200);
				code.setToken(foundUser.getPassword());
			} else {
				code.setStatus(400);
			}
		} catch(Exception e) {
			System.out.printf("%s", e.toString());
		}
		
		return new ResponseEntity<>(code, HttpStatus.OK);
	}
	
	@GetMapping(path="/basicAuth/{token}")
	public BasicAuthentication authentication(@PathVariable String token) {
		BasicAuthentication code = new BasicAuthentication(100);
		//get 'normal' String username and password from token
		//String username = this.convertAsciiToUsername(token);
		//String password = this.convertAsciiToPassword(token);
		
		//check if username and password are found and match
			//set code 200 for successful login
			//set code 400 for unsuccessful login
		
		return code;
	}
	
	/*
	 * private String convertAsciiToUsername(String token) { return ""; }
	 * 
	 * private String convertAsciiToPassword(String token) { return ""; }
	 */
}
