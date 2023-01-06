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

import com.allenfc.rest.webservices.restfullwebservices.services.ItemService;

//delete after testing
import com.allenfc.rest.webservices.restfullwebservices.models.Item;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping(path="/")
	public String home() {
		return "home";
	}
	
	@GetMapping(path="/items-list")
	public List<Item> getAllItems() {
		
		return itemService.findAll();
	}
	
	@GetMapping(path="items/{id}")
	public Item getItemById(@PathVariable Long id) {
		return itemService.findItemById(id);
		
	}
	
	@DeleteMapping(path="/items/delete/{id}")
	public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
		System.out.println("backend");
		itemService.deleteItemById(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping(path="/items/update/{id}")
	public ResponseEntity<Item> updateItem(
			@PathVariable Long id, 
			@RequestBody Item item) {
		Item updatedItem = itemService.saveItem(item);
		
		return new ResponseEntity<Item>(updatedItem, HttpStatus.OK);
		
	}
	
	@PostMapping(path="/items/create")
	public ResponseEntity<Void> createItem(@RequestBody Item item) {
		Item createdItem = itemService.saveItem(item);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdItem.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
    
}
