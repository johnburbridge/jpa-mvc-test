package org.metabuild.poc.services;

import java.util.List;

import org.metabuild.poc.domain.Person;
import org.metabuild.poc.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Person> findByName(String name) {
		return  repository.findByName(name);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Person> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Person findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Person save(Person newPerson) {
		return repository.save(newPerson);
	}
}
