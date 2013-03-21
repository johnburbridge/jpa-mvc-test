package org.metabuild.poc.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.metabuild.poc.AbstractDataTester;
import org.metabuild.poc.domain.Group;
import org.metabuild.poc.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonServiceIntegrationTest extends AbstractDataTester {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private GroupService groupService;

	@Test
	public void testFindAll() {
		List<Person> persons = personService.findAll();
		assertNotNull(persons);
		assertTrue(persons.size() >= 10);
	}
	
	@Test
	public void testCreate() {
		Person newPerson = new Person();
		assertNull(newPerson.getId());
		assertNull(newPerson.getName());
		newPerson.setName("testPerson1");
		Person savedPerson = personService.save(newPerson);
		assertNotNull(savedPerson);
		assertNotNull(savedPerson.getId());
		assertEquals(newPerson, savedPerson);
	}
	
	@Test
	public void testFindAndUpdate() {
		Person existingPerson = personService.findById("a85765e0-7e90-47b9-aea3-7da16117d274");
		assertNotNull(existingPerson);
		assertEquals("person0", existingPerson.getName());
		existingPerson.setName("zoinks!");
		personService.save(existingPerson);
		
		Person savedPerson = personService.findById("a85765e0-7e90-47b9-aea3-7da16117d274");
		assertEquals("zoinks!", savedPerson.getName());
		existingPerson.setName("person0");
		assertEquals("person0", personService.save(existingPerson).getName());
	}
	
	@Test
	public void testCreateManyToMany() {
		Person newPerson = new Person("testPersonWithGroups");
//		newPerson.setName("testPersonWithGroups");
		Person savedPerson = personService.save(newPerson);
		assertNotNull(savedPerson);
		assertNotNull(savedPerson.getId());
		assertEquals(newPerson, savedPerson);
		
		Group group1 = new Group();
		group1.setName("group1");
		Group savedGroup1 = groupService.save(group1);
		assertNotNull(savedGroup1);
		assertNotNull(savedGroup1.getId());
		assertEquals(group1, savedGroup1);
		
		Group group2 = new Group();
		group2.setName("group2");
		Group savedGroup2 = groupService.save(group2);
		assertNotNull(savedGroup2);
		assertNotNull(savedGroup2.getId());
		assertEquals(group2, savedGroup2);
		
		Group group3 = new Group();
		group3.setName("group3");
		Group savedGroup3 = groupService.save(group3);
		assertNotNull(savedGroup3);
		assertNotNull(savedGroup3.getId());
		assertEquals(group3, savedGroup3);
		
		savedPerson.addGroup(group1);
		savedPerson.addGroup(group2);
		savedPerson.addGroup(group3);
		
		Person resultPerson = personService.save(savedPerson);
		assertNotNull(resultPerson);
		assertEquals(3, resultPerson.getGroups().size());
	}
}
