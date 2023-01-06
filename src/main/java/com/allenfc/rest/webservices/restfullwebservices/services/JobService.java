package com.allenfc.rest.webservices.restfullwebservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allenfc.rest.webservices.restfullwebservices.dao.IJobRepo;
import com.allenfc.rest.webservices.restfullwebservices.models.Job;

@Service
public class JobService {
	/*
	 * private static List<Job> jobs = new ArrayList<Job>(); private static int
	 * idCounter = 0;
	 */
	
	/*
	 * static { jobs.add(new Job(++idCounter, "Dough Master",
	 * "become the master of dough", 15)); jobs.add(new Job(++idCounter,
	 * "Evening Manager", "Manage team memebers", 20)); jobs.add(new
	 * Job(++idCounter, "Cashier",
	 * "get customers on their way by handling payments", 14.50)); }
	 */
	private IJobRepo jobRepo;
	
	@Autowired
	public JobService(IJobRepo jobRepo) {
		this.jobRepo = jobRepo;
	}
	public List<Job> findAll() {
		return jobRepo.findAll();
	}
	
	public Job findJobById(long id) {
		return jobRepo.findById(id).get();
	}
	
	public List<Job> findJobByTitle(String title) {
		return jobRepo.findJobByTitle(title);
	}
	
	public Job deleteJobById(long id) {
		Job job = findJobById(id);
		if(job != null) {
			jobRepo.delete(job);
			return job;
		}
		
		return null;
	}
	
	//handles creating and updating Job entity
		public Job saveJob(Job job) {
			return jobRepo.save(job);
		}
}














