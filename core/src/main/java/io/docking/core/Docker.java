package io.docking.core;


import io.docking.core.order.Order;

/**
 *
 *
 */
public interface Docker {

    /**
     *
     * @param orderOne
     * @param orderTwo
     * @param wagonBatchOne
     * @param wagonBatchTwo
     * @return the {@link DockingPlan DockingPlan} to get on each wagon batch
     *         the matching order
     */
	DockingPlan dock(Order orderOne, Order orderTwo, WagonBatch wagonBatchOne,
              WagonBatch wagonBatchTwo);

}
