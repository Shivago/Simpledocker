package io.docker.ui;

import com.google.inject.Singleton;
import io.docker.ui.view.application.ApplicationView;
import io.docker.ui.view.docker.DockerView;
import io.docker.ui.view.order.OrderItemView;
import io.docker.ui.view.order.OrderSelectionListView;
import io.docker.ui.view.order.OrderView;
import io.docking.core.order.OrderItem;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sascha on 06.01.16.
 */
@Singleton
public class ServiceController {

    @FXML
    private ApplicationView applicationView;
    public TabPane tabPane;

    @FXML
    private OrderView orderView;

    @FXML
    private OrderItemView orderItemView;

    @FXML
    private OrderSelectionListView orderSelectionListView;
    private List<OrderItem> firstOrder, secondOrder;
    private List<OrderItem> firstDelivery, secondDelivery;

    @FXML
    private DockerView dockerView;
    private ListView firstOrderListView, secondOrderListView;
    private ListView firstDeliveryListView, secondDeliveryListView;

    @FXML
    public void initialize() {

    }

    public void setTabPane(TabPane tabPane) {
        this.tabPane = tabPane;
    }

    public void changeToTab(int tabNr) {
        tabPane.getSelectionModel().select(tabNr);
    }

    public void setFirstOrder(List<OrderItem> items) {
        firstOrder = items;
    }

    public List<OrderItem> getFirstOrder() {
        return firstOrder;
    }

    public void setSecondOrder(List<OrderItem> items) {
        secondOrder = items;
    }

    public List<OrderItem> getSecondOrder() {
        return secondOrder;
    }

    public List<OrderItem> getFirstDelivery() {
        return firstDelivery;
    }

    public void setFirstDelivery(List<OrderItem> firstDelivery) {
        this.firstDelivery = firstDelivery;
    }

    public List<OrderItem> getSecondDelivery() {
        return secondDelivery;
    }

    public void setSecondDelivery(List<OrderItem> secondDelivery) {
        this.secondDelivery = secondDelivery;
    }

    public void setFirstOrderListView(ListView firstOrderListView) {
        this.firstOrderListView = firstOrderListView;
    }

    public void setSecondOrderListView(ListView secondOrderListView) {
        this.secondOrderListView = secondOrderListView;
    }

    public ListView getFirstDeliveryListView() {
        return firstDeliveryListView;
    }

    public void setFirstDeliveryListView(ListView firstDeliveryListView) {
        this.firstDeliveryListView = firstDeliveryListView;
    }

    public ListView getSecondDeliveryListView() {
        return secondDeliveryListView;
    }

    public void setSecondDeliveryListView(ListView secondDeliveryListView) {
        this.secondDeliveryListView = secondDeliveryListView;
    }

    // send data to other views

    public void firstOrderToDockerView(List<OrderItem> firstOrder) {
        firstOrderListView.setItems(FXCollections.observableList(firstOrder));
    }

    public void secondOrderToDockerView(List<OrderItem> secondOrder) {
        secondOrderListView.setItems(FXCollections.observableArrayList(secondOrder));
    }

    public void firstDeliveryToDockerView(List<OrderItem> deliveryOne) {
        List<String> productNames = new ArrayList<>();
        for (OrderItem item : deliveryOne) {
            for (int i = 0; i < item.getAmount(); i++) {
                if (item.getProduct() == null) {
                    productNames.add("n/a");
                } else {
                    productNames.add(item.getProduct().getName());
                }
            }
        }
        this.firstDeliveryListView.setItems(FXCollections.observableArrayList(productNames));
    }

    public void secondDeliveryToDockerView(List<OrderItem> deliveryTwo) {
        List<String> productNames = new ArrayList<>();
        for (OrderItem item : deliveryTwo) {
            for (int i = 0; i < item.getAmount(); i++) {
                if (item.getProduct() == null) {
                    productNames.add("n/a");
                } else {
                    productNames.add(item.getProduct().getName());
                }
            }
        }
        this.secondDeliveryListView.setItems(FXCollections.observableArrayList(productNames));
    }
}