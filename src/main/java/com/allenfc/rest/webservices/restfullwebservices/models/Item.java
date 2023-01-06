package com.allenfc.rest.webservices.restfullwebservices.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="items")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private Double price;
	
	/* @ManyToMany(mappedBy="items") */
	//private List<User>users = new ArrayList<>();
	
	
	public Item() {
		
	}
	
	public Item(Long id, String name, String description, Double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Long getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getPrice() {
		return this.price;
	}

	/*
	 * public List<User> getUsers() { return users; }
	 * 
	 * public void setUsers(List<User> users) { this.users = users; }
	 */
	
	
	
}
