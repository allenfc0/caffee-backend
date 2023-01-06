package com.allenfc.rest.webservices.restfullwebservices.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.allenfc.rest.webservices.restfullwebservices.models.Item;

@Repository
public interface IItemRepo extends JpaRepository<Item, Long> {
	List<Item> findItemByName(String name);
}
