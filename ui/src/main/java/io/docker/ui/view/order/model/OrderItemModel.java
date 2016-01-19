package io.docker.ui.view.order.model;

import io.docker.ui.services.ProductService;
import io.docking.core.order.OrderItem;
import io.docking.core.order.Product;
import javafx.beans.property.*;

import javax.inject.Inject;

/**
 * Created by Sascha Ormanns on 17.01.16.
 */
public class OrderItemModel {

    private final ProductService productService;

    private IntegerProperty amount;

    private Property<Product> product;

    private Property<OrderItem> orderItem;

    @Inject
    public OrderItemModel(ProductService productService) {
        this.productService = productService;
        amount = new SimpleIntegerProperty(4);
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
