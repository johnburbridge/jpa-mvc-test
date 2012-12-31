/**
 * 
 */
package org.metabuild.poc.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author jburbridge
 *
 */
public class Person implements Serializable {
	
	private static final long serialVersionUID = 150135564407144746L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	@Column(name = "ID")
	private String id;
	
	@Column(name = "NAME")
	private String name;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "GROUP_MEMBERS",
		joinColumns = @JoinColumn(name = "PERSON_ID"),
		inverseJoinColumns = @JoinColumn(name = "GROUP_ID"))
	private Set<Group> groups = new HashSet<Group>();
	
}
