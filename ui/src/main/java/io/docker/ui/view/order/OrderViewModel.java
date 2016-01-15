package io.docker.ui.view.order;

import de.saxsys.mvvmfx.ViewModel;
import de.saxsys.mvvmfx.utils.notifications.NotificationCenter;
import io.docking.core.order.OrderItem;
import javafx.collections.FXCollections;

import java.util.List;
import javax.inject.Inject;

/**
 * @author sascha on 02/12/15.
 */
public class OrderViewModel implements ViewModel {

    @Inject
    private NotificationCenter notificationCenter;

    public List<OrderItem> order1 = FXCollections.observableArrayList();
    public List<OrderItem> order2 = FXCollections.observableArrayList();
    public List<OrderItem> delivery1 = FXCollections.observableArrayList();
    public List<OrderItem> delivery2 = FXCollections.observableArrayList();

    public OrderViewModel() {}

    public List<OrderItem> getOrder1() {
        return order1;
    }

    public List<OrderItem> getOrder2() {
        return order2;
    }

    public List<OrderItem> getDelivery1() {
        return delivery1;
    }

    public List<OrderItem> getDelivery2() {
        return delivery2;
    }

}
