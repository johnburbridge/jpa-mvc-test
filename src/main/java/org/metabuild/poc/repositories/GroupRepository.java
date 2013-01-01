/**
 * 
 */
package org.metabuild.poc.repositories;

import java.util.List;

import org.metabuild.poc.domain.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jburbridge
 *
 */
@Transactional
public interface GroupRepository extends CrudRepository<Group, String> {

	public List<Group> findByName(String name);
	
	public List<Group> findAll();
	
	public Group findById(String id);

}
