package io.docker.ui.viewmodel.order;

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

    public OrderItemViewModel() {
        amount = new SimpleIntegerProperty();
        product = new SimpleObjectProperty<>();
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
}
