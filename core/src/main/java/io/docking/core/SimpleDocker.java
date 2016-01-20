package io.docking.core;


import io.docking.core.order.Order;

import java.util.List;

/**
 * 
 * @author Jean-Philippe Quéméner
 *
 */
public class SimpleDocker implements Docker {

	@Override
	public DockingPlan dock(List<Order> orders, List<WagonBatch> trains) {
		return null;
	}
}
