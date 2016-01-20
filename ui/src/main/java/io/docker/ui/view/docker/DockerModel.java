package io.docker.ui.view.docker;

import io.docker.ui.services.OrderDeliveryDataService;
import io.docking.core.order.OrderItem;
import io.docking.core.order.Product;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;

import javax.inject.Inject;

/**
 * Created by Sascha Ormanns on 18.01.16.
 */
public class DockerModel {

    private final OrderDeliveryDataService orderDeliveryDataService;

    private SimpleListProperty<OrderItem> order1propertyList = new SimpleListProperty<>();
    private SimpleListProperty<OrderItem> order2propertyList = new SimpleListProperty<>();
    private SimpleListProperty<Product> delivery1propertyList = new SimpleListProperty<>();
    private SimpleListProperty<Product> delivery2propertyList = new SimpleListProperty<>();

    @Inject
    public DockerModel(OrderDeliveryDataService orderDeliveryDataService) {
        this.orderDeliveryDataService = orderDeliveryDataService;
    }

    public void deleteOrderItem() {

    }

    public ObservableList<OrderItem> getOrder1propertyList() {
        return order1propertyList.get();
    }

    public SimpleListProperty<OrderItem> order1propertyListProperty() {
        return order1propertyList;
    }

    public void setOrder1propertyList(ObservableList<OrderItem> order1propertyList) {
        this.order1propertyList.set(order1propertyList);
    }

    public ObservableList<OrderItem> getOrder2propertyList() {
        return order2propertyList.get();
    }

    public SimpleListProperty<OrderItem> order2propertyListProperty() {
        return order2propertyList;
    }

    public void setOrder2propertyList(ObservableList<OrderItem> order2propertyList) {
        this.order2propertyList.set(order2propertyList);
    }

    public ObservableList<Product> getDelivery1propertyList() {
        return delivery1propertyList.get();
    }

    public SimpleListProperty<Product> delivery1propertyListProperty() {
        return delivery1propertyList;
    }

    public void setDelivery1propertyList(ObservableList<Product> delivery1propertyList) {
        this.delivery1propertyList.set(delivery1propertyList);
    }

    public ObservableList<Product> getDelivery2propertyList() {
        return delivery2propertyList.get();
    }

    public SimpleListProperty<Product> delivery2propertyListProperty() {
        return delivery2propertyList;
    }

    public void setDelivery2propertyList(ObservableList<Product> delivery2propertyList) {
        this.delivery2propertyList.set(delivery2propertyList);
    }
}
