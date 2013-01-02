package org.metabuild.poc.repositories;

import java.util.List;

import org.metabuild.poc.domain.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * @author jburbridge
 *
 */
public interface PersonRepository extends CrudRepository<Person, String> {

	public List<Person> findByName(String name);
	
	public List<Person> findAll();
	
	public Person findById(String id);
	
}
