package io.docker.ui.view.docker;

import com.google.inject.Inject;
import de.saxsys.mvvmfx.ViewModel;
import io.docker.ui.services.OrderDeliveryDataService;
import io.docking.core.order.OrderItem;
import io.docking.core.order.Product;
import javafx.collections.FXCollections;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sascha Ormanns on 02/12/15.
 */
public class DockerViewModel implements ViewModel {

    private final OrderDeliveryDataService orderDeliveryDataService;

    @Inject
    public DockerViewModel(OrderDeliveryDataService orderDeliveryDataService) {
        this.orderDeliveryDataService = orderDeliveryDataService;
    }

    public void initDeliveries(ListView deliveryOne, ListView deliveryTwo) {
        List<OrderItem> delivery1 = orderDeliveryDataService.getData().getDelivery1();
        List<Product> productList1 = getProductsFrom(delivery1);
        deliveryOne.setItems(FXCollections.observableList(productList1));

        List<OrderItem> delivery2 = orderDeliveryDataService.getData().getDelivery2();
        List<Product> productList2 = getProductsFrom(delivery2);
        deliveryTwo.setItems(FXCollections.observableList(productList2));
    }

    private List<Product> getProductsFrom(List<OrderItem> orderItems) {
        List<Product> products = new ArrayList<>();
        for (OrderItem item : orderItems) {
            for (int i = 0; i < item.getAmount(); i++) {
                if (item.getProduct() == null) {
                    products.add(null);
                } else {
                    products.add(item.getProduct());
                }
            }
        }
        return products;
    }

}
