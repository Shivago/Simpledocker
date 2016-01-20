package io.docker.ui.view.order;

import de.saxsys.mvvmfx.ViewModel;
import io.docking.core.order.OrderItem;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

import javax.inject.Inject;

/**
 * @author Sascha Ormanns on 02/12/15.
 */
public class OrderSelectionListViewModel implements ViewModel {

    private Property<OrderItem> orderItem1 = new SimpleObjectProperty<>();
    private Property<OrderItem> orderItem2 = new SimpleObjectProperty<>();
    private Property<OrderItem> orderItem3 = new SimpleObjectProperty<>();
    private Property<OrderItem> orderItem4 = new SimpleObjectProperty<>();
    private Property<OrderItem> orderItem5 = new SimpleObjectProperty<>();

    private SimpleListProperty<Property<OrderItem>> orderItemPropertyList = new SimpleListProperty<>();

    private OrderSelectionListModel orderSelectionListModel;

    @Inject
    public OrderSelectionListViewModel(OrderSelectionListModel orderSelectionListModel) {
        this.orderSelectionListModel = orderSelectionListModel;
        orderItem1.bindBidirectional(orderSelectionListModel.orderItem1Property());
        orderItem2.bindBidirectional(orderSelectionListModel.orderItem2Property());
        orderItem3.bindBidirectional(orderSelectionListModel.orderItem3Property());
        orderItem4.bindBidirectional(orderSelectionListModel.orderItem4Property());
        orderItem5.bindBidirectional(orderSelectionListModel.orderItem5Property());
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
