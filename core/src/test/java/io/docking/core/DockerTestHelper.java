package io.docking.core;

import io.docking.core.order.Order;
import io.docking.core.order.OrderItem;
import io.docking.core.order.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * @author Jean-Philippe Quéméner
 */
public abstract class DockerTestHelper {


    public static WagonBatch getTrainOne() {
        return new WagonBatch(new ArrayList<>(Arrays.asList(
                       Product.get("ipad"),
                       Product.get("ipad"),
                       Product.get("macbook")
        )));

    }

    public static WagonBatch getTrainTwo() {
        return new WagonBatch(new ArrayList<>(Arrays.asList(
                Product.get("macbook"),
                Product.get("macbook"),
                Product.get("ipad"),
                Product.get("ipad")
        )));
    }

    public static Order getOrderOne() {
        return new Order(Arrays.asList(
                new OrderItem(Product.get("ipad"), 4)
        ));
    }

    public static Order getOrderTwo() {
        return new Order(Arrays.asList(
                new OrderItem(Product.get("macbook"), 3)
        ));
    }

    /**
     *
     * @param rearrangedTrains
     * @return
     */
    public static  boolean validateArrangement(List<WagonBatch> rearrangedTrains) {
        return rearrangedTrains.stream()
                .filter(wagonBatch -> {
                    Order order = wagonBatch.getOrder().get();
                    List<Product> wagons = wagonBatch.getWagons();
                    for (OrderItem orderItem : order.getItems()) {
                        int count = 0;
                        for (Product product : wagons) {
                            if (product.equals(orderItem.getProduct())) {
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
