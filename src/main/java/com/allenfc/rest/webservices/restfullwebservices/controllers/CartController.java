package com.allenfc.rest.webservices.restfullwebservices.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.allenfc.rest.webservices.restfullwebservices.models.Cart;
import com.allenfc.rest.webservices.restfullwebservices.services.CartService;

@RestController
@CrossOrigin(origins="*")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping(path="/carts-list")
	public List<Cart> getAllCarts() {
		return cartService.findAll();
	}
	
	@GetMapping(path="/carts/{id}")
	public Cart getCartById(@PathVariable Long id) {
		return cartService.findCartById(id);
	}
	
	@DeleteMapping(path="/carts/delete/{id}")
	public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
		cartService.deleteCartById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path={"/carts/update/{id}", "/carts/orderred/{id}"})
	public ResponseEntity<Cart> updateCart(
			@PathVariable Long id,
			@RequestBody Cart cart) {
		Cart updatedCart = cartService.saveCart(cart);
		
		return new ResponseEntity<Cart>(updatedCart, HttpStatus.OK);
	}
	
	@PostMapping(path="/carts/create")
	public ResponseEntity<Void> createCart(@RequestBody Cart cart) {
		Cart createdCart = cartService.saveCart(cart);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdCart.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(path="/carts/list/user-id/{id}")
	public List<Cart> findCartListByUserId(@PathVariable Long id) {
		return cartService.findCartListByUserId(id);
	}
	
	
	
}









