package io.docking.core;

import io.docking.core.order.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 
 * @author sascha
 *
 */
public class WagonBatch {

	private List<Wagon> wagons;

	public WagonBatch(List<Wagon> wagons) {
		this.wagons = wagons;
	}

	private WagonBatch() {}

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
		return wagons;
	}

	public void setWagons(List<Wagon> wagons) {
		this.wagons = new ArrayList<>(wagons);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		wagons.forEach(stringBuilder::append);
		return stringBuilder.toString();
	}

}
