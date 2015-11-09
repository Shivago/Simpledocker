package de.bwv.order;

/**
 * 
 * @author sascha
 *
 */
public class OrderItem {

	private Product product;
	private int amount;

	public OrderItem(Product product, int amount) {
		this.product = product;
		this.amount = amount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String toString() {
		return "OrderItem: " + product.toString() + ", Amount: " + amount + " ";
	}

}
