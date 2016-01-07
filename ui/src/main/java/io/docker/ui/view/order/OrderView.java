package io.docker.ui.view.order;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import io.docker.ui.ServiceController;
import io.docker.ui.viewmodel.order.OrderItemViewModel;
import io.docker.ui.viewmodel.order.OrderViewModel;
import io.docking.core.order.OrderItem;
import io.docking.core.order.Product;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;

import javax.inject.Inject;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author sascha on 02/12/15.
 */
public class OrderView implements FxmlView<OrderViewModel>, Initializable {

    @Inject
    private ServiceController serviceController;

    @FXML
    // Injection of the application which is declared in the FXML File
    private Tab orderView; // Value injected by FXMLLoader

    @InjectViewModel
    private OrderViewModel viewModel;

    @Inject
    private OrderItemViewModel itemViewModel;

    @FXML
    private Parent orderSelectionListViewOne;

    @FXML
    private Parent orderSelectionListViewTwo;

    @FXML
    private Parent orderSelectionListViewThree;

    @FXML
    private Parent orderSelectionListViewFour;

    @FXML
    private OrderSelectionListView orderSelectionListViewOneController;

    @FXML
    private OrderSelectionListView orderSelectionListViewTwoController;

    @FXML
    private OrderSelectionListView orderSelectionListViewThreeController;

    @FXML
    private OrderSelectionListView orderSelectionListViewFourController;

    @FXML
    private Button saveButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Orders
        orderSelectionListViewOneController.setSelectionListHeading("Koblenz");
        orderSelectionListViewTwoController.setSelectionListHeading("Neuss");
        // Deliveries
        orderSelectionListViewThreeController.setSelectionListHeading("Liége");
        orderSelectionListViewFourController.setSelectionListHeading("Maastricht");

        initOrderSelectionLists();
        setOrderListDefaultValues();
    }

    private void initOrderSelectionLists() {
        List<OrderSelectionListView> listViews = new ArrayList<>(
                Arrays.asList(orderSelectionListViewOneController,
                              orderSelectionListViewTwoController,
                              orderSelectionListViewThreeController,
                              orderSelectionListViewFourController));
        List<OrderItem> orderItems;
        List<ComboBox<Product>> comboBoxes;
        for (OrderSelectionListView view : listViews) {
            orderItems = getOrderItemsFrom(view);
            comboBoxes = view.getAllComboboxes();
            for (ComboBox box : comboBoxes) {
                for (OrderItem item : orderItems) {
                    box.getItems().add(item.getProduct());
                }
            }
        }
    }

    public void setOrderListDefaultValues() {
        List<OrderSelectionListView> listViews = new ArrayList<>(
                Arrays.asList(orderSelectionListViewOneController,
                              orderSelectionListViewTwoController));
        List<OrderItem> orderItems;
        List<ComboBox<Product>> comboBoxes;

        for (OrderSelectionListView view : listViews) {
            orderItems = getOrderItemsFrom(view);
            comboBoxes = view.getAllComboboxes();
            for (int i = 0; i < orderItems.size(); i++) {
                comboBoxes.get(i).setValue(orderItems.get(i).getProduct());
            }
        }
    }

    private List<OrderItem> getOrderItemsFrom(OrderSelectionListView view) {
        return view.getViewModel().getOrderItems();
    }

    @FXML
    void saveButtonPressed(final ActionEvent event) {
        serviceController.setFirstOrder(orderSelectionListViewOneController.getOrderItems());
        serviceController.setSecondOrder(orderSelectionListViewTwoController.getOrderItems());
        serviceController.firstOrderToDockerView(serviceController.getFirstOrder());
        serviceController.secondOrderToDockerView(serviceController.getSecondOrder());

        serviceController.setFirstDelivery(orderSelectionListViewThreeController.getOrderItems());
        serviceController.setSecondDelivery(orderSelectionListViewFourController.getOrderItems());
        serviceController.firstDeliveryToDockerView(serviceController.getFirstDelivery());
        serviceController.secondDeliveryToDockerView(serviceController.getSecondDelivery());

        serviceController.changeToTab(1);
    }

}
