/**
 * 
 */
package org.metabuild.poc.services;

import java.util.List;

import org.metabuild.poc.domain.Group;
import org.metabuild.poc.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Service("groupService")
public class GroupServiceImpl implements GroupService {

	@Autowired
	GroupRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Group> findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Group> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Group findById(String id) {
		return repository.findById(id);
	}
}
