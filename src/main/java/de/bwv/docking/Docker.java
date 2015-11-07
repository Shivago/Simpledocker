package de.bwv.docking;

import de.bwv.order.Order;

/**
 * 
 * @author ormanns_sas
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
