package io.docking.core;


import io.docking.core.order.Order;

/**
<<<<<<< HEAD
 * Simple interface that provides a {@link DockingPlan DockingPlan} for the
=======
 * @author Jean-Philippe Quéméner
 *
 * Simple interface that provide a {@link DockingPlan DockingPlan} for the
>>>>>>> master
 * given {@link io.docking.core.order.Order orders} and
 * {@link WagonBatch wagonbatchs}.
 */
public interface Docker {

<<<<<<< HEAD
       /**
	*
	* @param orderOne - order from the first destination
	* @param orderTwo - order from the second destination
	* @param wagonBatchOne - delivery from the first location
	* @param wagonBatchTwo - delivery from the second location
	*
	* @return the {@link DockingPlan DockingPlan} to get on each wagonbatch
	*         the matching order
	*/
=======
    /**
     *
     * @param orderOne - order from the first destination
     * @param orderTwo - order from the second destination
     * @param wagonBatchOne - delivery from the first location
     * @param wagonBatchTwo - delivery from the second location
		 *
     * @return the {@link DockingPlan DockingPlan} to get on each wagon batch
     *         the matching order
     */
>>>>>>> master
	DockingPlan dock(Order orderOne, Order orderTwo, WagonBatch wagonBatchOne,
	      WagonBatch wagonBatchTwo);

}
