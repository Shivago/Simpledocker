package io.docking.core;


import io.docking.core.order.Order;

/**
 * @author Jean-Philippe Quéméner
 *
 * Simple interface that provide a {@link DockingPlan DockingPlan} for the
 * given {@link io.docking.core.order.Order orders} and
 * {@link WagonBatch wagonbatchs}.
 */
public interface Docker {

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
	DockingPlan dock(Order orderOne, Order orderTwo, WagonBatch wagonBatchOne,
              WagonBatch wagonBatchTwo);

}
