package org.formation.coffeemachine.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author ib
 *
 */
@Entity
public class Coffee {

	@Id
	private String id;
	private String name;

	public Coffee() {
		
	}
	
	public Coffee(String name) {
		this(UUID.randomUUID().toString(), name);
	}

	public Coffee(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Coffee [id=" + id + ", name=" + name + "]";
	}
	
	

}
