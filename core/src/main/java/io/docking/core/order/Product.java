package io.docking.core.order;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

/**
 *
 * Represents a product used in the algorithm. Use static constructor
 * {@link Product#get(String)} to initialize.
 *
 * @author Jean-Philippe Quéméner
 *
 */
public class Product {

    /**
     * Name of the Product
     */
	private final String name;

    /**
     * Static cache for Product instances
     */
    static private final HashMap<String, Product> cache = new HashMap<>();

	public Product(@NotNull String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object product) {
		if (product instanceof Product) {
			Product inputCasted = (Product) product;
			if (name.equals(inputCasted.name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public String toString() {
		return "Product=" + getName();
	}

	/**
	 *
	 * Checks the cache if already an instance of the product exists. If not a
	 * new one will be created, added to the cache and returned. If product
	 * already exists the cached instance will be returned.
	 *
	 * @param name
	 * @return product corresponding to the given name
     */
	public static Product get(String name) {
		if (!cache.containsKey(name)) {
			cache.put(name, new Product(name));
		}
		return cache.get(name);
	}
}
