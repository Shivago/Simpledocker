package io.docker.ui.viewmodel.order;

import de.saxsys.mvvmfx.ViewModel;
import io.docking.core.order.Product;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * @author sascha on 02/12/15.
 */
public class OrderItemViewModel implements ViewModel {

    private IntegerProperty amount;

    private Property<Product> product;

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
}
