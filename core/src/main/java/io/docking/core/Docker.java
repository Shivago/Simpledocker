package io.docking.core;


import io.docking.core.order.Order;

import java.util.List;

/**
 * @author Jean-Philippe Quéméner
 *
 * Simple interface that provide a {@link DockingPlan DockingPlan} for the
 * given {@link io.docking.core.order.Order orders} and
 * {@link WagonBatch wagonbatches}.
 */
public interface Docker {


   /**

	* @param orders - all orders that need to be fulfilled
	* @param trains - the trains that need to be rearranged
	*
	* @return the {@link DockingPlan DockingPlan} to get on each wagonbatch
	*         the matching order
	*/

	DockingPlan dock(List<Order> orders, List<WagonBatch> trains);

}
