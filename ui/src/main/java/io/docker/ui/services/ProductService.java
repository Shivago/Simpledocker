package io.docker.ui.services;

import io.docking.core.order.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;
import java.util.List;
import javax.inject.Singleton;

/**
 * Created by johnny on 1/9/16.
 */
@Singleton
public class ProductService {

    public List<Product> getProducts() {
        return Arrays.asList(
                new Product("MB", "MacBook Pro"),
                new Product("IM", "iMac"),
                new Product("IP", "iPad Pro"),
                new Product("PH", "iPhone 6s"),
                new Product("AW", "Apple Watch")
        );
    }

    public ObservableList<Product> getProductsAsOrderItemObservableList() {
        return FXCollections.observableList(Arrays.asList(
                new Product("MB", "MacBook Pro"),
                new Product("IM", "iMac"),
                new Product("IP", "iPad Pro"),
                new Product("PH", "iPhone 6s"),
                new Product("AW", "Apple Watch")
        ));
    }

}