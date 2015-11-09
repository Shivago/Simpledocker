package io.docking.core;


import io.docking.core.order.Product;

/**
 * 
 * @author sascha
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
