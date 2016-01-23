package io.docking.core;

import io.docking.core.order.Order;
import io.docking.core.order.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.IntStream;

/**
 *
 * A sorted collection of {@link Product} representing a Rail/Train
 *
 * @author Jean-Philippe Quéméner
 *
 */
public class WagonBatch {

	private final String id;

	private List<Product> products;

	private Order order;

	public WagonBatch(String id, List<Product> products) {
		this.products = products;
		this.id = id;
	}

	public WagonBatch(List<Product> products) {
		this.products = products;
		this.id = UUID.randomUUID().toString();
	}

	public WagonBatch(String id) {
		this.id = id;
	}

	public WagonBatch() {
        this.products = new ArrayList<>();
		this.id = UUID.randomUUID().toString();
    }

	public int getAmountOfProduct(final Product inputProduct) {
		return (int) products.stream()
							.filter(product -> product.equals(inputProduct))
							.count();
	}

	public int getIndexOfProduct(final Product product) {
		return IntStream.range(0, products.size())
				.filter(index -> products.get(index).equals(product))
				.findFirst()
				.getAsInt();
	}

	public int getSize() {
		return products.size();
	}

	public List<Product> getWagons() {
		return new ArrayList<>(products);
	}

	public void setWagons(List<Product> products) {
		this.products = new ArrayList<>(products);
	}


	public Optional<Order> getOrder() {
		return Optional.ofNullable(order);
	}

	public void setOrder(final Order order) {
		this.order = order;
	}

	public String getId() {
		return id;
	}

	public WagonBatch appendWagon(final Product product) {
		products.add(product);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		products.forEach(stringBuilder::append);
		return stringBuilder.toString();
	}

	public Optional<Product> firstElement() {
		return Optional.ofNullable(products.get(0));
	}

	public WagonBatch appendWagons(List<Product> products) {
		this.products.addAll(products);
		return this;
	}

	public void clearProducts() {
		products.clear();
	}

	public boolean needsProduct(Product product) {
		if (order == null) {
			throw new IllegalStateException("This method can only be called" +
					" when the WagonBatch already got an order assigned.");
		}
		// todo implement!
		return true;
	}


    /**
     *
     * @param index start index in the list
     */
    public List<Product> removeStartingByIndex(final int index) {
        List<Product> resultList = new ArrayList<>();
        if (!products.isEmpty()) {
            for (int i = index; i <= products.size(); i++) {
                resultList.add(products.remove(index));
            }
        }
        return resultList;
    }
}
