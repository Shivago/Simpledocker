package io.docking.core;


import io.docking.core.order.Order;

import java.util.List;

/**
 * @author Jean-Philippe Quéméner
 *
 * Simple interface that provide a {@link List} for the
 * given {@link io.docking.core.order.Order orders} and
 * {@link WagonBatch wagonbatches}.
 */
public interface Docker {


   /**

	* @param orders - all orders that need to be fulfilled
	* @param trains - the trains that need to be rearranged
	*
	* @return the {@link List} of docking steps to get on each wagonbatch
	*         the matching order
	*/

	List<Docking> dock(final List<Order> orders, final List<WagonBatch> trains);

}
