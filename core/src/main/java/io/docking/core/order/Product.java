package io.docking.core.order;

import java.util.HashMap;
import java.util.UUID;

/**
 * 
 * @author sascha
 *
 */
public class Product {

	private final String id;
	private final String name;

	static private final HashMap<String, Product> cache = new HashMap<>();

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
			Product inputCasted = (Product) product;
			if (name.equals(inputCasted.name) && id.equals(inputCasted.id)) {
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

	public static Product get(String name) {
		if (!cache.containsKey(name)) {
			cache.put(name, new Product(UUID.randomUUID().toString(), name));
		}
		return cache.get(name);
	}
}
