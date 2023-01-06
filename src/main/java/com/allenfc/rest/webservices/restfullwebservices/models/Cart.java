package com.allenfc.rest.webservices.restfullwebservices.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "Cart")
@Table(name = "cart")
public class  Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID",  nullable = false, //
	foreignKey = @ForeignKey(name = "USER_ID_FK"))
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM_ID",  nullable = false, //
	foreignKey = @ForeignKey(name = "ITEM_ID_FK"))
	private Item item;
	
	@Column(name = "quantity", nullable = false)
	private Integer quantity;
	
	@Column(name = "amount", nullable = false)
	private Double amount;
	
	private Boolean submitted;
	
	public Cart() {
		
	}
	
	public Cart(User user, Item item, Integer quantity, Double amount) {
		this.user = user;
		this.item =  item;
		this.quantity = quantity;
		this.amount = amount;
		this.submitted = false;
	}
	
	public Cart(Long id, User user, Item item, Integer quantity, Double amount) {
		this.id = id;
		this.user = user;
		this.item =  item;
		this.quantity = quantity;
		this.amount = amount;
		this.submitted = false;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Item.class)
//	@JoinColumn(name="item_id")
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public Boolean getSubmitted() {
		return submitted;
	}
	
	public void setSubmitted(Boolean submitted) {
		this.submitted = submitted;
	}
	
}
