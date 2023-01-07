package com.allenfc.rest.webservices.restfullwebservices.controllers;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allenfc.rest.webservices.restfullwebservices.models.Item;
import com.allenfc.rest.webservices.restfullwebservices.models.Job;
import com.allenfc.rest.webservices.restfullwebservices.models.TestingBean;
import com.allenfc.rest.webservices.restfullwebservices.models.User;
import com.allenfc.rest.webservices.restfullwebservices.security.BCryptEncoder;
import com.allenfc.rest.webservices.restfullwebservices.services.ItemService;
import com.allenfc.rest.webservices.restfullwebservices.services.JobService;
import com.allenfc.rest.webservices.restfullwebservices.services.UserService;

@RestController
@CrossOrigin(origins="http://gavi-caffee.surge.sh")
public class MiscController {
	
	@Autowired
	private ItemService itemService;
	@Autowired
	private JobService jobService;
	@Autowired
	private UserService userService;
	
	BCryptEncoder encoder = new BCryptEncoder();
	
	@GetMapping(path="/testing")
	public TestingBean helloWorld() {
		return new TestingBean("hello testing");
	}
	
	@GetMapping(path="*")
	public String getError() {
		return "Error Path";
	}
	
	@PostConstruct
    public void init() {
		
		Job j = new Job(20001L, "Dough Master", "become the master of dough", 15);
        jobService.saveJob(j);
		
        Item i = new Item(1001L, "donut", "chocolate", 2.69);
        Item i1 = new Item(1006L, "coffee", "strawberry", 2.69);
        Item i2 = new Item(1009L, "coffee cake", "vanilla", 2.69);
        Item i3 = new Item(1012L, "hot chocolate", "hot", 2.69);
        itemService.saveItem(i);
        itemService.saveItem(i1);
        itemService.saveItem(i2);
        itemService.saveItem(i3);
        
        
        User u = new User(10001L, "Allen", "allenfc", "allenfarias29@gmail.com", "pass", "ROLE_USER", true);
        User u1 = new User(10002L, "admin1", "admin", "admin@gmail.com", "pass", "ROLE_ADMIN", true);
        User basicUser = new User(10003L, "John", "jd", "john.doe@gmail.com", "pass");
        userService.saveUser(u);
        userService.saveUser(u1);
        userService.saveUser(basicUser);
       
        
		
//		  Cart donut = new Cart(u, i, 12, 12*i.getPrice()); 
//		  Cart donut1 = new Cart(u1, i, 12, 12*i.getPrice()); 
		  
//		  Cart coffee = new Cart(2L, i1.getId(), 1); 
//		  Cart coffeeCake = new Cart(3L, i2.getId(), 4); 
//		  Cart hotChocolate = new Cart(4L, i3.getId(), 3);
//		 
		  
		  //cartService.saveCart(donut);
		  //cartService.saveCart(donut1);
		  
//		  u.addToCart(donut);
//		  u.addToCart(coffee);
//		  u1.addToCart(donut);
//		  u1.addToCart(coffeeCake);
       
		/*
		 * u.addOrderItem(hotChocolate); u.addOrderItem(coffee);
		 * u1.addOrderItem(coffeeCake); u1.addOrderItem(dozenDonuts);
		 */
       
       
	}
        

	//before destroyed
    @PreDestroy
    public void destroy(){
        System.out.println("Destroyed! lol");
    }
}
