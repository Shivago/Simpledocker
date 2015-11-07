package de.bwv.order;

/**
 * 
 * @author ormanns_sas
 *
 */
public class Product {

	private final String id;
	private final String name;

	public Product(String id, String name) {
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
	public boolean equals(Object product) {
		if (product instanceof Product) {
			if (name == ((Product) product).getName()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return id.hashCode() + name.hashCode();
	}

	@Override
	public String toString() {
		return "Product -> Id: " + getId() + ", Name: " + getName();
	}
	
}