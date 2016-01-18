package io.docker.ui.view.order.viewmodel;

import de.saxsys.mvvmfx.ViewModel;
import io.docker.ui.services.ProductService;
import io.docker.ui.view.order.model.OrderItemModel;
import io.docking.core.order.OrderItem;
import io.docking.core.order.Product;
import javafx.beans.property.*;

import javax.inject.Inject;

/**
 * @author sascha on 02/12/15.
 */
public class OrderItemViewModel implements ViewModel {

    private final ProductService productService;

    private IntegerProperty amount;

    private Property<Product> product;

    private Property<OrderItem> orderItem;

    private OrderItemModel orderItemModel;

    @Inject
    public OrderItemViewModel(OrderItemModel orderItemModel, ProductService productService) {
        this.productService = productService;
        this.orderItemModel = orderItemModel;
        amount = new SimpleIntegerProperty();
        product = new SimpleObjectProperty<>();
        orderItem = new SimpleObjectProperty<>();

        amount.bindBidirectional(orderItemModel.getAmountProperty());
        product.bindBidirectional(orderItemModel.getProductProperty());
        orderItem.bindBidirectional(orderItemModel.getOrderItemProperty());

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

    public void setProduct(Property<Product> product) {
        this.product = product;
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
