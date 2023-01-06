package com.allenfc.rest.webservices.restfullwebservices.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allenfc.rest.webservices.restfullwebservices.models.Job;

public interface IJobRepo extends JpaRepository<Job, Long>{
	List<Job> findJobByTitle(String title);
}
