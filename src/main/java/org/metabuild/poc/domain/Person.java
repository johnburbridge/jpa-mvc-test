/**
 * 
 */
package org.metabuild.poc.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author jburbridge
 *
 */
@Entity
@Table(name="PERSONS")
public class Person implements Serializable {
	
	private static final long serialVersionUID = -8308249849068261850L;

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
	
	public Person() {}
	
	public Person(String name) {
//		this.id = UUID.randomUUID().toString();
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the groups
	 */
	public Set<Group> getGroups() {
		return groups;
	}

	/**
	 * @param groups the groups to set
	 */
	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	/**
	 * @param group the group to add
	 */
	public void addGroup(Group group) {
		groups.add(group);
	}
	
	/**
	 * @param groups the groups to add
	 */
	public void addGroups(List<Group> groups) {
		this.groups.addAll(groups);
	}
}
