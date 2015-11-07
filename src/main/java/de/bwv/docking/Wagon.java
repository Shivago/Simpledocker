package de.bwv.docking;

import de.bwv.order.Product;

/**
 * 
 * @author ormanns_sas
 *
 */
public class Wagon {

	private Product product;

	public Wagon(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Override
	public String toString() {
		return "Wagon <-> " + product.toString();
	}

}
