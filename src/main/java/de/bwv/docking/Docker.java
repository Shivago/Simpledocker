package de.bwv.docking;

import de.bwv.order.Order;

/**
 * 
 * @author sascha
 *
 */
public interface Docker {

	/**
	 *
	 * @param order
	 * @param source
	 * @param destination
     */
	void dock(Order order, WagonBatch source, WagonBatch destination);

}
