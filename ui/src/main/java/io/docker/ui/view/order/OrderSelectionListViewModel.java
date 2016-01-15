package io.docker.ui.view.order;

import de.saxsys.mvvmfx.ViewModel;
import io.docking.core.order.OrderItem;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;

/**
 * @author sascha on 02/12/15.
 */
public class OrderSelectionListViewModel implements ViewModel {

    private Property<OrderItem> orderItem1 = new SimpleObjectProperty<>();
    private Property<OrderItem> orderItem2 = new SimpleObjectProperty<>();
    private Property<OrderItem> orderItem3 = new SimpleObjectProperty<>();
    private Property<OrderItem> orderItem4 = new SimpleObjectProperty<>();
    private Property<OrderItem> orderItem5 = new SimpleObjectProperty<>();


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
}
