package io.docker.ui.viewmodel.order;

import de.saxsys.mvvmfx.ViewModel;
import io.docking.core.order.OrderItem;
import io.docking.core.order.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sascha on 02/12/15.
 */
public class OrderSelectionListViewModel implements ViewModel {

    private List<OrderItem> orderItems;

    public OrderSelectionListViewModel() {}

    public List<OrderItem> getOrderItems() {
        orderItems = new ArrayList<>(Arrays.asList(
                new OrderItem(new Product("MB", "MacBook Pro"), 0),
                new OrderItem(new Product("IM", "iMac"), 0),
                new OrderItem(new Product("IP", "iPad Pro"), 0),
                new OrderItem(new Product("PH", "iPhone 6s"), 0),
                new OrderItem(new Product("AW", "Apple Watch"), 0)
        ));
        return orderItems;
    }
}
