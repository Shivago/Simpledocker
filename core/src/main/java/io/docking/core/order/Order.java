package io.docking.core.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author Jean-Philippe Quéméner
 *
 */
public class Order {

	/**
	 * Immutable list of {@link OrderItem}
	 */
	private final List<OrderItem> items;

    /**
     *
     * @param items
     */
	public Order(final List<OrderItem> items) {
		this.items = Collections.unmodifiableList(items);
	}

    /**
     *
     * @return immutable list of {@link OrderItem orderitems}
     */
	public List<OrderItem> getItems() {
		return new ArrayList<>(items);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		items.forEach(item -> stringBuilder.append(",").append(item));
		return stringBuilder.toString().substring(1);
	}

	public List<Product> getProducts() {
		return items.stream()
					.map(item -> item.getProduct())
					.collect(Collectors.toList());
	}
}
