package io.docker.ui.viewmodel.order;

import de.saxsys.mvvmfx.ViewModel;
import io.docking.core.order.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sascha on 02/12/15.
 */
public class OrderSelectionListViewModel implements ViewModel {

    private List<Product> productList;

    public OrderSelectionListViewModel() {}

    public List<Product> getProductList() {
        productList = new ArrayList<>(Arrays.asList(
                new Product("MB", "MacBook Pro"),
                new Product("IM", "iMac"),
                new Product("IP", "iPad Pro"),
                new Product("PH", "iPhone 6s"),
                new Product("AW", "Apple Watch")
        ));
        return productList;
    }
}
