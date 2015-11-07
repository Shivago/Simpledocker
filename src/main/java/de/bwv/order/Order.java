package de.bwv.order;

import java.util.List;

/**
 * 
 * @author ormanns_sas
 *
 */
public class Order {

	private List<OrderItem> items;
	private Destination destination;

	public Order(List<OrderItem> items, Destination destination) {
		this.items = items;
		this.destination = destination;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (OrderItem i : items) {
			stringBuilder.append(i);
		}
		return stringBuilder.toString();
	}
}
