package com.allenfc.rest.webservices.restfullwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.allenfc.rest.webservices.restfullwebservices.controllers.MiscController;
import com.allenfc.rest.webservices.restfullwebservices.models.User;
import com.allenfc.rest.webservices.restfullwebservices.services.UserService;

//@Configuration
//@ComponentScan(basePackageClasses = {User.class, MiscController.class})
public class BCryptEncoder {
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	//@Bean
	public String passwordEncoder(String password) {
		return encoder.encode(password);
	}
	
	public Boolean checkPassword(String raw, String encrypted) {
		return encoder.matches(raw, encrypted);
	}
}
