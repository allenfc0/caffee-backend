package com.allenfc.rest.webservices.restfullwebservices.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.allenfc.rest.webservices.restfullwebservices.security.BCryptEncoder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
//, schema = "caffee_app"
@Table(name="users")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class User {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	
	//private Set<Cart> cart = (Set<Cart>) new ArrayList<Cart>();
	
	@Transient
	private BCryptEncoder encoder = new BCryptEncoder();
	
	public User() {
		
	}
	
	public User(Long id, String name, String username, String email, String basicPassword) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = basicPassword;
	}
	
	/*
	 * public User(String name, String username, String email, String password) {
	 * this.name = name; this.username = username; this.email = email; this.password
	 * = encoder.passwordEncoder(password); }
	 * 
	 * public User(Long id, String name, String username, String email, String
	 * password) { this.id = id; this.name = name; this.username = username;
	 * this.email = email; this.password = encoder.passwordEncoder(password); }
	 */

	//this contructor is ONLY for encrypting password. When Spring Security is implemented
	/*
	 * public User(Long id, String name, String username, String email, String
	 * password) { this.id = id; this.name = name; this.username = username;
	 * this.email = email; this.password = encoder.passwordEncoder(password);
	 * 
	 * }
	 */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	//change in future when user wants to reset their password
	public void setPassword(String password) {
		this.password = password;
	}

	
	/*
	 * @OneToMany(cascade = CascadeType.ALL, targetEntity = Cart.class)
	 * 
	 * @JoinTable(name="user_cart", joinColumns= @JoinColumn(name="user_id"),
	 * inverseJoinColumns= @JoinColumn(name="cart_id"))
	 * // @JoinColumn(name="cart_id") public Set<Cart> getCart() { return cart; }
	 * 
	 * public void setCart(Set<Cart> cart) { this.cart = cart; }
	 * 
	 * public void addToCart(Cart orderItem) { this.cart.add(orderItem); }
	 */

	/*
	 * public List<Item> getitems() { return items; }
	 * 
	 * public void setitems(List<Item> items) { this.items = items; }
	 * 
	 * public void addItem(Item item) { items.add(item); item.getUsers().add(this);
	 * }
	 */
	
	
	
	
}
