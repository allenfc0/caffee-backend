package com.allenfc.rest.webservices.restfullwebservices.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.allenfc.rest.webservices.restfullwebservices.models.Cart;

@Repository
public interface ICartRepo extends JpaRepository<Cart, Long>{
	//List<Cart> findCartByName(String name);
	
	@Query(value="SELECT c.* FROM cart c WHERE c.user_id=?1", nativeQuery=true)
	List<Cart> findCartListByUserId(Long id);
}
