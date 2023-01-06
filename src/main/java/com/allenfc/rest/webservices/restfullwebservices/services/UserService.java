package com.allenfc.rest.webservices.restfullwebservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allenfc.rest.webservices.restfullwebservices.dao.IUserRepo;
import com.allenfc.rest.webservices.restfullwebservices.models.User;

@Service
public class UserService {
	
	private IUserRepo userRepo;
	
	@Autowired
	public UserService(IUserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	public Iterable<User> findAll() {
		return userRepo.findAll();
	}
	
	public User findUserById(Long id) {
		return userRepo.findById(id).get();
	}
	
	public User findUserByUsername(String username) {
		return userRepo.findUserByUsername(username);
	}
	
	public User deleteUserById(Long id) {
		User user = findUserById(id);
		if(user != null) {
			userRepo.delete(user);
			return user;
		}
		return null;
	}
	
	public User saveUser(User user) {
		System.out.println("start saving user");
		return userRepo.save(user);
	}
	
	public Long getNextAvailableId() {
		return userRepo.findNextAvailableId();
	}
}







