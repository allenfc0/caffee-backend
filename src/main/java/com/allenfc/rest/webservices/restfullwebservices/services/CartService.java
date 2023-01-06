package com.allenfc.rest.webservices.restfullwebservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allenfc.rest.webservices.restfullwebservices.dao.ICartRepo;
import com.allenfc.rest.webservices.restfullwebservices.models.Cart;

@Service
public class CartService {
	
	private ICartRepo cartRepo;
	
	@Autowired
	public CartService(ICartRepo cartRepo) {
		this.cartRepo = cartRepo;
	}
	
	public List<Cart> findAll() {
		return cartRepo.findAll();
	}
	
	public Cart findCartById(Long id) {
		return cartRepo.findById(id).get();
	}
	
	/*
	 * public List<Cart> findCartByName(String name) { return
	 * cartRepo.findCartByName(name); }
	 */
	
	public Cart deleteCartById(Long id) {
		Cart cart = findCartById(id);
		if(cart != null) {
			cartRepo.delete(cart);
		}
		return null;
	}
	
	//@Transactional(rollbackOn = Exception.class)
	public Cart saveCart(Cart cart) {
		//Session session = this.sessionFactory.getCurrentSession();
		System.out.println("start saving cart");
		return cartRepo.save(cart);
		//session.persist(cart);
	}
	
	
	public List<Cart> findCartListByUserId(Long id) {
		return cartRepo.findCartListByUserId(id);
	}
	
}
