
  package com.allenfc.rest.webservices.restfullwebservices.dao;
  
  import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.allenfc.rest.webservices.restfullwebservices.models.User;
  
  @Repository
  public interface IUserRepo extends CrudRepository<User, Long>{
	  User findUserByName(String name);

	  //id, email, name, password, username
	  @Query(value="SELECT u.* FROM users u WHERE u.username =  ?1", nativeQuery=true)
	  User findUserByUsername(String username);
	  
	  @Query(value="SELECT COUNT(u.id) FROM users u", nativeQuery=true)
	  Long findNextAvailableId();
  }
 
