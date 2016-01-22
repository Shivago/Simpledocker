package io.docking.core;

import io.docking.core.order.Order;
import io.docking.core.order.OrderItem;
import io.docking.core.order.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by johnny on 1/21/16.
 */
public abstract class DockerTestsuite {

    abstract public void shouldFulfillEveryOrder();


    protected WagonBatch getTrainOne() {
        return new WagonBatch(new ArrayList<>(Arrays.asList(
                       new Wagon(Product.get("ipad")),
                       new Wagon(Product.get("ipad")),
                       new Wagon(Product.get("macbook"))
        )));

    }

    protected WagonBatch getTrainTwo() {
        return new WagonBatch(new ArrayList<>(Arrays.asList(
                new Wagon(Product.get("macbook")),
                new Wagon(Product.get("macbook")),
                new Wagon(Product.get("ipad")),
                new Wagon(Product.get("ipad"))
        )));
    }

    protected Order getOrderOne() {
        return new Order(Arrays.asList(
                new OrderItem(Product.get("ipad"), 4)
        ));
    }

    protected Order getOrderTwo() {
        return new Order(Arrays.asList(
                new OrderItem(Product.get("macbook"), 3)
        ));
    }

    /**
     *
     * @param rearrangedTrains
     * @return
     */
    protected boolean validateArrangement(List<WagonBatch> rearrangedTrains) {
        return rearrangedTrains.stream()
                .filter(wagonBatch -> {
                    Order order = wagonBatch.getOrder().get();
                    List<Wagon> wagons = wagonBatch.getWagons();
                    for (OrderItem orderItem : order.getItems()) {
                        int count = 0;
                        for (Wagon wagon : wagons) {
                            if (wagon.getProduct().equals(orderItem.getProduct())) {
                                count++;
                            }
                        }
                        if (count != orderItem.getAmount()) {
                            return false;
                        }
                    }
                    return true;
                }).count() == rearrangedTrains.size();
    }

}
