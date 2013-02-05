package org.metabuild.poc;

import java.util.List;

import org.metabuild.poc.config.SpringConfig;
import org.metabuild.poc.domain.Group;
import org.metabuild.poc.domain.Person;
import org.metabuild.poc.services.GroupService;
import org.metabuild.poc.services.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class AppRunner {

//	private final static ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
	private final static ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

	protected void printPersons() {

		PersonService personService = (PersonService) context.getBean("personService");

		System.out.println("Listing persons:");
		for (Person person : personService.findAll()) {
			System.out.println(person.getId() + " : " + person.getName());
		}
		System.out.println("Done listing persons.\n");
	}
	
	protected void printGroups() {
		
		GroupService groupService = (GroupService) context.getBean("groupService");
		
		System.out.println("Listing groups:");
		for (Group group : groupService.findAll()) {
			System.out.println(group.getId() + " : " + group.getName());
		}
		System.out.println("Done listing persons.\n");
	}

	protected void printPersonsDetailsJavaConfig() {
	
		PersonService personService = (PersonService) context.getBean("personService");
//		JpaTransactionManager transactionManager = (JpaTransactionManager) context.getBean("transactionManager");
//		TransactionDefinition defintion = new DefaultTransactionDefinition();
//		TransactionStatus status = transactionManager.getTransaction(defintion);
		
		List<Person> persons = personService.findByName("person0");
		System.out.println("Listing person with details:");
		if (persons.size() > 0) {
			StringBuilder stringBuilder = new StringBuilder("Found record(s)!\n");
			for (Person person : persons) {
				stringBuilder.append("Id: ").append(person.getId()).append("\n")
					.append("Name:" ).append(person.getName()).append("\n")
					.append("Groups: ").append(person.getGroups().size());
			}
			System.out.println(stringBuilder.toString());
			System.out.println("Done listing persons with details.\n");
		} else {
			System.err.println("No records found!");
		}
		
//		transactionManager.commit(status);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		AppRunner runner = new AppRunner();
		runner.printPersons();
		runner.printGroups();
		runner.printPersonsDetailsJavaConfig();
	}
}
