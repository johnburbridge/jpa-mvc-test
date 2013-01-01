package org.metabuild.poc.services;

import java.util.List;

import org.metabuild.poc.domain.Person;
import org.springframework.transaction.annotation.Transactional;

public interface PersonService {

	@Transactional
	public List<Person> findByName(String name);
	
	@Transactional
	public List<Person> findAll();
	
	@Transactional
	public Person findById(String id);
	
}
