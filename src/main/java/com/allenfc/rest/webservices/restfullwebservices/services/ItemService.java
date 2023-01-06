package com.allenfc.rest.webservices.restfullwebservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allenfc.rest.webservices.restfullwebservices.dao.IItemRepo;
import com.allenfc.rest.webservices.restfullwebservices.models.Item;

@Service
public class ItemService {
	/*
	 * private static List<Item> items = new ArrayList<Item>(); private static long
	 * idCounter = 0;
	 */
	
	/*
	 * static { items.add(new Item(++idCounter, "donut", "round with hole", 2.50));
	 * items.add(new Item(++idCounter, "coffee", "hot water", 3.00)); items.add(new
	 * Item(++idCounter, "cake", "strawberry flavor", 12.50)); }
	 */
	private IItemRepo itemRepo;
	
	@Autowired
	public ItemService(IItemRepo itemRepo) {
		this.itemRepo = itemRepo;
	}
	
	
	
	public List<Item> findAll() {
		return itemRepo.findAll();
	}
	
	public Item findItemById(long id) {
		
		return itemRepo.findById(id).get();
		
	}
	
	public List<Item> findItemByName(String name) {
		return itemRepo.findItemByName(name);
	}
	
	/*
	 * List<Item> itemList = this.findAll().; for(Item item : itemList) {
	 * if(item.getId() == id) { return item; } } return null;
	 */
	
	public Item deleteItemById(long id) {
		Item item = findItemById(id);
		if(item != null) {
			itemRepo.deleteById(id);
			return item;
		}
		
		return null;
	}
	
	//handles creating and updating Item entity
	/*
	 * public Item save(Item item) { if(item.getId() == -1 || item.getId() == 0) {
	 * item.setId(++idCounter); items.add(item); } else {
	 * //this.deleteItemById(item.getId()); items.set((int) ((Long)item.getId() -
	 * 1), item); } return item; }
	 */
	
	public Item saveItem(Item item) {
		return itemRepo.save(item);
	}
	
}
