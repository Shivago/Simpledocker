package io.docker.ui.view.docker;

import com.google.inject.Inject;
import de.saxsys.mvvmfx.ViewModel;
import io.docker.ui.services.OrderDeliveryDataService;
import io.docking.core.order.OrderItem;
import io.docking.core.order.Product;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sascha Ormanns on 02/12/15.
 */
public class DockerViewModel implements ViewModel {

    private DockerModel dockerModel;

    private SimpleListProperty<OrderItem> order1propertyList = new SimpleListProperty<>();
    private SimpleListProperty<OrderItem> order2propertyList = new SimpleListProperty<>();
    private SimpleListProperty<Product> delivery1propertyList = new SimpleListProperty<>();
    private SimpleListProperty<Product> delivery2propertyList = new SimpleListProperty<>();

    private final OrderDeliveryDataService orderDeliveryDataService;

    @Inject
    public DockerViewModel(DockerModel dockerModel, OrderDeliveryDataService orderDeliveryDataService) {
        this.dockerModel = dockerModel;
        this.orderDeliveryDataService = orderDeliveryDataService;
        order1propertyList.bindBidirectional(dockerModel.order1propertyListProperty());
        order2propertyList.bindBidirectional(dockerModel.order2propertyListProperty());
        delivery1propertyList.bindBidirectional(dockerModel.delivery1propertyListProperty());
        delivery2propertyList.bindBidirectional(dockerModel.delivery2propertyListProperty());
    }

    public void initOrderLists(ListView orderOne, ListView orderTwo) {
        orderOne.setItems(FXCollections.observableList(orderDeliveryDataService.getData().getOrder1()));
        orderTwo.setItems(FXCollections.observableList(orderDeliveryDataService.getData().getOrder2()));
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

    public void delete() {
        dockerModel.deleteOrderItem();
    }

    public ObservableList<OrderItem> getOrder1propertyList() {
        return order1propertyList.get();
    }

    public SimpleListProperty<OrderItem> order1propertyListProperty() {
        return order1propertyList;
    }

    public void setOrder1propertyList(ObservableList<OrderItem> order1propertyList) {
        this.order1propertyList.set(order1propertyList);
    }

    public ObservableList<OrderItem> getOrder2propertyList() {
        return order2propertyList.get();
    }

    public SimpleListProperty<OrderItem> order2propertyListProperty() {
        return order2propertyList;
    }

    public void setOrder2propertyList(ObservableList<OrderItem> order2propertyList) {
        this.order2propertyList.set(order2propertyList);
    }

    public ObservableList<Product> getDelivery1propertyList() {
        return delivery1propertyList.get();
    }

    public SimpleListProperty<Product> delivery1propertyListProperty() {
        return delivery1propertyList;
    }

    public void setDelivery1propertyList(ObservableList<Product> delivery1propertyList) {
        this.delivery1propertyList.set(delivery1propertyList);
    }

    public ObservableList<Product> getDelivery2propertyList() {
        return delivery2propertyList.get();
    }

    public SimpleListProperty<Product> delivery2propertyListProperty() {
        return delivery2propertyList;
    }

    public void setDelivery2propertyList(ObservableList<Product> delivery2propertyList) {
        this.delivery2propertyList.set(delivery2propertyList);
    }

}
