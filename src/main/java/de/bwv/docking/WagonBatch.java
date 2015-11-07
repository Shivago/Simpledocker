package de.bwv.docking;


import de.bwv.order.Product;

import java.util.List;

/**
 * 
 * @author ormanns_sas
 *
 */
public class WagonBatch {

	private List<Wagon> wagons;

	public WagonBatch(List<Wagon> wagons) {
		this.wagons = wagons;
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
		wagons.stream()
				.filter(wagon -> wagon.getProduct().equals(product))
				.count();
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
		return idx;
	}

	public int getSize() {
		return wagons.size();
	}

	public List<Wagon> getWagons() {
		return wagons;
	}

	public void setWagons(List<Wagon> wagons) {
		this.wagons = wagons;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Wagon wagon : wagons) {
			stringBuilder.append(wagon);
		}
		return stringBuilder.toString();
	}
}
