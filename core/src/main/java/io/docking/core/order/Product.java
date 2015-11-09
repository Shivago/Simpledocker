package io.docking.core.order;

import java.util.UUID;

/**
 * 
 * @author sascha
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
		return getId() + ", " + getName();
	}

	public static Product get(char c) {
		return new Product(UUID.randomUUID().toString(), String.valueOf(c));
	}
}
