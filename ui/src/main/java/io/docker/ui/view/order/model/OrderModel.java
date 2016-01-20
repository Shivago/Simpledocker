package io.docker.ui.view.order.model;

import io.docking.core.order.OrderItem;
import javafx.beans.property.SimpleListProperty;

import javax.inject.Inject;

/**
 * Created by Sascha Ormanns on 17.01.16.
 */
public class OrderModel {

    private SimpleListProperty<OrderItem> order1 = new SimpleListProperty<>();
    private SimpleListProperty<OrderItem> order2 = new SimpleListProperty<>();
    private SimpleListProperty<OrderItem> delivery1 = new SimpleListProperty<>();
    private SimpleListProperty<OrderItem> delivery2 = new SimpleListProperty<>();

    @Inject
    public OrderModel() {}

    public SimpleListProperty<OrderItem> getOrder1() {
        return order1;
    }

    public SimpleListProperty<OrderItem> getOrder2() {
        return order2;
    }

    public SimpleListProperty<OrderItem> getDelivery1() {
        return delivery1;
    }

    public SimpleListProperty<OrderItem> getDelivery2() {
        return delivery2;
    }

}
