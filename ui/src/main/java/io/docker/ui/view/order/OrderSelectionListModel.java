package io.docker.ui.view.order;

import io.docking.core.order.OrderItem;
import io.docking.core.order.Product;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

/**
 * Created by Sascha Ormanns on 17.01.16.
 */
public class OrderSelectionListModel {

    private Property<OrderItem> orderItem1 = new SimpleObjectProperty<>();
    private Property<OrderItem> orderItem2 = new SimpleObjectProperty<>();
    private Property<OrderItem> orderItem3 = new SimpleObjectProperty<>();
    private Property<OrderItem> orderItem4 = new SimpleObjectProperty<>();
    private Property<OrderItem> orderItem5 = new SimpleObjectProperty<>();

    private SimpleListProperty<Property<OrderItem>> orderItemPropertyList = new SimpleListProperty<>();

    public OrderSelectionListModel() {
        orderItem1.setValue(new OrderItem(new Product("MB", "MacBook Pro"), 0));
        orderItem2.setValue(new OrderItem(new Product("IM", "iMac"), 0));
        orderItem3.setValue(new OrderItem(new Product("IP", "iPad Pro"), 0));
        orderItem4.setValue(new OrderItem(new Product("PH", "iPhone 6s"), 0));
        orderItem5.setValue(new OrderItem(new Product("AW", "Apple Watch"), 0));

    }

    public Property<OrderItem> orderItem1Property() {
        return orderItem1;
    }

    public Property<OrderItem> orderItem2Property() {
        return orderItem2;
    }

    public Property<OrderItem> orderItem3Property() {
        return orderItem3;
    }

    public Property<OrderItem> orderItem4Property() {
        return orderItem4;
    }

    public Property<OrderItem> orderItem5Property() {
        return orderItem5;
    }

    public ObservableList<Property<OrderItem>> getOrderItemPropertyList() {
        return orderItemPropertyList.get();
    }

    public SimpleListProperty<Property<OrderItem>> orderItemPropertyListProperty() {
        return orderItemPropertyList;
    }

    public void setOrderItemPropertyList(ObservableList<Property<OrderItem>> orderItemPropertyList) {
        this.orderItemPropertyList.set(orderItemPropertyList);
    }

    public void addOrderItemProperty(Property<OrderItem> orderItemProperty) {
        orderItemPropertyList.add(orderItemProperty);
    }
}
