package io.docking.core.order;

/**
 *
 * @author Jean-Philippe Quéméner
 *
 */
public class OrderItem {

	private final Product product;
	private final int amount;

	/**
	 *
	 * @param product
	 * @param amount
     */
	public OrderItem(Product product, int amount) {
		this.product = product;
		this.amount = amount;
	}

	public Product getProduct() {
		return product;
	}

	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return "OrderItem: " + product.toString() + ", Amount: " + amount + " ";
	}

}
