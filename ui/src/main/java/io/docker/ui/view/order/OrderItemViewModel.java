package io.docker.ui.view.order;

import de.saxsys.mvvmfx.ViewModel;
import de.saxsys.mvvmfx.utils.mapping.ModelWrapper;
import io.docking.core.order.OrderItem;
import io.docking.core.order.Product;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * @author sascha on 02/12/15.
 */
public class OrderItemViewModel implements ViewModel {

    private ModelWrapper<OrderItem> wrapper = new ModelWrapper<>();

    private IntegerProperty amount = wrapper.field(OrderItem::getAmount, OrderItem::setAmount, 0);

    private Property<Product> product = wrapper.field(OrderItem::getProduct, OrderItem::setProduct);

    private Property<OrderItem> orderItem;

    public OrderItemViewModel() {
        amount = new SimpleIntegerProperty();
        product = new SimpleObjectProperty<>();
        orderItem = new SimpleObjectProperty<>();
    }

    public IntegerProperty getAmountProperty() {
        return amount;
    }

    public Property<Product> getProductProperty() {
        return product;
    }

    public Product getProduct() {
        return product.getValue();
    }

    public int getAmount() {
        return amount.get();
    }

    public void setAmount(IntegerProperty amount) {
        this.amount = amount;
    }

    public Property<OrderItem> getOrderItemProperty() {
        return orderItem;
    }

    public OrderItem getOrderItem() {
        return orderItem.getValue();
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem.setValue(orderItem);
    }


}
