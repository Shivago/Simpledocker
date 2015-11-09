package io.docking.core.order;

/**
 * 
 * @author sascha
 *
 */
public class Destination {

	private final String id;
	private final String name;

	public Destination(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Destination -> Id: " + getId() + ", Name: " + getName();
	}
}
