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
 * @author sascha
 *
 */
public class WagonBatch {

	private String id = UUID.randomUUID().toString();

	private List<Wagon> wagons;

	private Order order;

	public WagonBatch(List<Wagon> wagons) {
		this.wagons = wagons;
	}

	public WagonBatch() {
        this.wagons = new ArrayList<>();
    }

	public int getAmountOfProduct(Product product) {
		return (int) wagons.stream()
							.filter(wagon -> wagon.getProduct().equals(product))
							.count();
	}

	public int getIndexOfProduct(Product product) {
		return IntStream.range(0, wagons.size())
				.filter(index -> wagons.get(index).getProduct().equals(product))
				.findFirst()
				.getAsInt();
	}

	public int getSize() {
		return wagons.size();
	}

	public List<Wagon> getWagons() {
		return new ArrayList<>(wagons);
	}

	public void setWagons(List<Wagon> wagons) {
		this.wagons = new ArrayList<>(wagons);
	}


	public Optional<Order> getOrder() {
		return Optional.ofNullable(order);
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getId() {
		return id;
	}

	public WagonBatch appendWagon(Wagon wagon) {
		wagons.add(wagon);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		wagons.forEach(stringBuilder::append);
		return stringBuilder.toString();
	}

	public Optional<Product> firstElement() {
        Wagon wagon = wagons.get(0);
        if (wagon != null) {
            return Optional.of(wagon.getProduct());
        }
		return Optional.empty();
	}

	public WagonBatch appendWagons(List<Wagon> wagons) {
		this.wagons.addAll(wagons);
		return this;
	}

	public void clearWagons() {
		wagons.clear();
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
    public List<Wagon> removeStartingByIndex(int index) {
        List<Wagon> resultList = new ArrayList<>();
        if (!wagons.isEmpty()) {
            for (int i = index; i <= wagons.size(); i++) {
                resultList.add(wagons.remove(index));
            }
        }
        return resultList;
    }
}
