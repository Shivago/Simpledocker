package io.docking.core;


import io.docking.core.order.Order;

/**
 * 
 * @author sascha
 *
 */
public class SimpleDocker implements Docker {

	@Override
	public DockingPlan dock(Order orderOne, Order orderTwo,
							WagonBatch wagonBatchOne, WagonBatch wagonBatchTwo) {
		return null;
	}
}
