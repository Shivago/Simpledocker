package io.docking.core;


import io.docking.core.order.Order;
import io.docking.core.order.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * Simple implementation of the {@link Docker} interface
 *
 * @author Jean-Philippe Quéméner
 *
 */
public class SimpleDocker implements Docker {

    private final WagonBatch bufferRail = new WagonBatch();

	@Override
	public List<Docking> dock(final List<Order> ordersInput,
                            final List<WagonBatch> trainsInput) {
		if (ordersInput.isEmpty() || trainsInput.isEmpty()
				|| (trainsInput.size() != ordersInput.size())) {
			throw new IllegalArgumentException();
		}
        // create a defensive copy of the input
        final List<Order> orders = new ArrayList<>(ordersInput);
        final List<WagonBatch> wagonBatches = new ArrayList<>(trainsInput);
        final List<Docking> dockingPlan = new ArrayList<>();
        List<WagonBatch> remainingTrains = wagonBatches.stream().filter(wagonBatch -> {
            for (Iterator<Order> iterator = orders.iterator();
                 iterator.hasNext();) {
                Order order = iterator.next();
                Optional<Product> firstProduct = wagonBatch.firstElement();
                if (firstProduct.isPresent() && order.getProducts()
                        .contains(firstProduct.get())) {
                    wagonBatch.setOrder(order);
                    bufferRail.appendWagons(wagonBatch.removeStartingByIndex(1));
                    iterator.remove();
                    dockingPlan.add(new Docking(null, wagonBatch, 1));
                    return false;
                }
            }
            return true;
        }).collect(Collectors.toList());
        // remove all prodcuts and add to buffer rail, add first remaining order
        remainingTrains.forEach(wagonBatch -> {
            List<Product> wagons = wagonBatch.getWagons();
            bufferRail.appendWagons(wagons);
            wagonBatch.clearProducts();
            // set first remaining order
            wagonBatch.setOrder(orders.remove(0));
            dockingPlan.add(new Docking(null, wagonBatch, 0));
        });
        // at this stage every train got an order and has only products it will need to fullfill the order
        // very simple task now, we just iterate over the buffer rail and dispatch it to one of our trains
        List<Product> bufferWagons = bufferRail.getWagons();
        for (ListIterator<Product> iterator = bufferWagons.listIterator(bufferWagons.size());
             iterator.hasPrevious();) {
            Product product = iterator.previous();
            for (WagonBatch wagonBatch : wagonBatches) {
                if (wagonBatch.needsProduct(product)) {
                    wagonBatch.appendWagon(product);
                    dockingPlan.add(new Docking(wagonBatch, null,
                            iterator.previousIndex() + 1));
                    iterator.remove();
                    break;
                }
            }
        }
        if (!bufferWagons.isEmpty()) {
            throw  new IllegalArgumentException("You have more products " +
                    "than ordered!");
        }
        return dockingPlan;
	}

}
