package io.docker.ui.view.order.view;

import com.jfoenix.controls.JFXButton;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.saxsys.mvvmfx.utils.notifications.NotificationCenter;
import io.docker.ui.services.OrderDeliveryDataService;
import io.docker.ui.services.TabService;
import io.docker.ui.view.order.viewmodel.OrderViewModel;
import io.docking.core.order.OrderItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javax.inject.Inject;

/**
 * @author Sascha Ormanns on 02/12/15.
 */
public class OrderView implements FxmlView<OrderViewModel>, Initializable {

    private final TabService tabService;

    private final OrderDeliveryDataService dataService;

    @InjectViewModel
    private OrderViewModel viewModel;

    @Inject
    private NotificationCenter notificationCenter;

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
    // Injection of the application which is declared in the FXML File
    private Tab orderView; // Value injected by FXMLLoader

    @FXML
    private JFXButton openOrderFile, openDeliveryFile;

    @FXML
    private TextField orderFileTextField, deliveryFileTextField;

    @FXML
    private Button saveButton;

    @Inject
    public OrderView(TabService tabService, OrderDeliveryDataService dataService) {
        this.tabService = tabService;
        this.dataService = dataService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Orders
        orderSelectionListViewOneController.setSelectionListHeading("Koblenz");
        orderSelectionListViewTwoController.setSelectionListHeading("Neuss");
        // Deliveries
        orderSelectionListViewThreeController.setSelectionListHeading("Liége");
        orderSelectionListViewFourController.setSelectionListHeading("Maastricht");

    }

    @FXML
    void saveButtonPressed(final ActionEvent event) {
        if (valid()) {
            dataService.setOrder1(orderSelectionListViewOneController.getOrderItems());
            dataService.setOrder2(orderSelectionListViewTwoController.getOrderItems());
            dataService.setDelivery1(orderSelectionListViewThreeController.getOrderItems());
            dataService.setDelivery2(orderSelectionListViewFourController.getOrderItems());
            notificationCenter.publish("saved");
            tabService.changeToTab(1);
        } else {
            // todo show dialog with error message
            System.out.println("The entered data isn't valid. Check it out.");
        }

    }

    @FXML
    void orderFileButtonPressed(final ActionEvent event) {
        File file = viewModel.openFileDialog(event);
        setText(file, orderFileTextField);
    }

    @FXML
    void deliveryFileButtonPressed(final ActionEvent event) {
        File file = viewModel.openFileDialog(event);
        setText(file, deliveryFileTextField);
    }

    private void setText(File file, TextField field) {
        if (file != null) {
            field.setText(file.getName());
        } else {
            field.setText("Datei n/a");
        }
    }

    private boolean valid() {
        // todo check orders against deliveries
        int maxAmount = 20;

        if (sumAmount(orderSelectionListViewOneController) <= maxAmount
                && sumAmount(orderSelectionListViewOneController) <= maxAmount
                && sumAmount(orderSelectionListViewOneController) <= maxAmount
                && sumAmount(orderSelectionListViewOneController) <= maxAmount) {
            return true;
        }
        return false;
    }

    public int sumAmount(OrderSelectionListView selectionListView) {
        int sum = 0;
        for (OrderItem item : selectionListView.getOrderItems()) {
            sum += item.getAmount();
        }
        return sum;
    }

}
