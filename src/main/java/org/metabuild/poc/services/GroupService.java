package org.metabuild.poc.services;

import java.util.List;

import org.metabuild.poc.domain.Group;

public interface GroupService {

	public List<Group> findByName(String name);
	
	public List<Group> findAll();
	
	public Group findById(String id);

	public Group save(Group group);
}
