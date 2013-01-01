/**
 * 
 */
package org.metabuild.poc.services;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


import org.junit.Before;
import org.junit.Test;

import org.metabuild.poc.domain.Person;
import org.metabuild.poc.repositories.PersonRepository;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * @author jburbridge
 *
 */
public class PersonServiceImplTest {
	
	private final List<Person> persons = new ArrayList<Person>();
	private PersonRepository repository;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		persons.add(new Person("fake-person"));
		repository = mockPersonRepository(persons);
	}

	@Test
	public void testMethods() {
		
		PersonService service = new PersonServiceImpl();
		ReflectionTestUtils.setField(service, "repository", repository);
		
		final Person testRecord = persons.get(0);
		final String id = testRecord.getId();
		
		assertNull(service.findById("b0rk"));
		assertEquals(testRecord, service.findById(id));
		assertEquals(persons, service.findByName("nameParam"));
		assertEquals(persons, service.findAll());

	}
	
	protected static PersonRepository mockPersonRepository(List<Person> persons) {
		PersonRepository repository = mock(PersonRepository.class);
		when(repository.findAll()).thenReturn(persons);
		when(repository.findByName(anyString())).thenReturn(persons);
		when(repository.findById(persons.get(0).getId())).thenReturn(persons.get(0));
		return repository;
	}
}
