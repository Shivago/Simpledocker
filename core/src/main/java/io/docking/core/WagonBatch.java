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

	private WagonBatch() {

	}

	public int getAmountOfProduct(Product product) {
		int counter = 0;
		Product prodToCompare = null;
		for (Wagon w : wagons) {
			prodToCompare = w.getProduct();
			if (prodToCompare.equals(product)) {
				counter ++;
			}
		}
//		wagons.stream()
//				.filter(wagon -> wagon.getProduct().equals(product))
//				.count();
		return counter;
	}

	public int getIndexOfProduct(Product product) {
		int idx = 0;
		Product prodToCompare = null;
		for (int i = 0; i < getSize(); i++) {
			prodToCompare = wagons.get(i).getProduct();
			if (prodToCompare.equals(product)) {
				idx = i;
				break;
			}
		}
//		IntStream.range(0, wagons.size())
//				.filter(index -> wagons.get(index).getProduct().equals(product))
//				.findFirst()
//				.getAsInt();
		return idx;
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

	/**
	 * Static constructor that enables us to take the plain
	 * String given by the project specs and parse it to a WagonBatch
	 * as we want to handle it oo-style.
	 * @param wagonBatchString i.e "ABBBCCCDD"
	 * @return
     */
	public static WagonBatch parse(final String wagonBatchString) throws IllegalArgumentException {
		if (wagonBatchString == null) {
			throw new IllegalArgumentException("wagonBatch should not be null");
		} else if (wagonBatchString.isEmpty()) {
			throw new IllegalArgumentException("wagonBatch should not be empty");
		}
		WagonBatch wagonBatch = new WagonBatch();
		List<Wagon> wagons = new ArrayList<>(wagonBatchString.length());
        IntStream.range(0, wagonBatchString.length()).forEach(index -> {
            Product product = Product.get(wagonBatchString.charAt(index));
            Wagon wagon = new Wagon(product);
            wagons.add(index, wagon);
        });
        wagonBatch.setWagons(wagons);
		return wagonBatch;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		wagons.forEach(stringBuilder::append);
		return stringBuilder.toString();
	}

}
