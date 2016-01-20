package io.docker.ui.view.order;

import de.saxsys.mvvmfx.ViewModel;
import de.saxsys.mvvmfx.utils.notifications.NotificationCenter;
import io.docking.core.order.OrderItem;
import javafx.beans.property.SimpleListProperty;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.FileChooser;

import java.io.File;
import javax.inject.Inject;

/**
 * @author Sascha Ormanns on 02/12/15.
 */
public class OrderViewModel implements ViewModel {

    private OrderModel orderModel;

    private NotificationCenter notificationCenter;

    private SimpleListProperty<OrderItem> order1 = new SimpleListProperty<>();
    private SimpleListProperty<OrderItem> order2 = new SimpleListProperty<>();
    private SimpleListProperty<OrderItem> delivery1 = new SimpleListProperty<>();
    private SimpleListProperty<OrderItem> delivery2 = new SimpleListProperty<>();

    @Inject
    public OrderViewModel(NotificationCenter notificationCenter, OrderModel orderModel) {
        this.notificationCenter = notificationCenter;
        order1.bindBidirectional(orderModel.getOrder1());
        order2.bindBidirectional(orderModel.getOrder2());
        delivery1.bindBidirectional(orderModel.getDelivery1());
        delivery2.bindBidirectional(orderModel.getDelivery2());

    }

    public File openFileDialog(final ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("TXT / CSV files (*.txt, *.csv)", "*.txt", "*.csv");
        fileChooser.getExtensionFilters().add(extensionFilter);
        File file = fileChooser.showOpenDialog(((Node)event.getTarget()).getScene().getWindow());

        return file != null ? file : null;
    }

    public SimpleListProperty<OrderItem> getOrder1() {
        return order1;
    }

    public SimpleListProperty<OrderItem> getOrder2() {
        return order2;
    }

    public SimpleListProperty<OrderItem> getDelivery1() {
        return delivery1;
    }

    public SimpleListProperty<OrderItem> getDelivery2() {
        return delivery2;
    }

}
