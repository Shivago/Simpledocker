package io.docker.ui.view.order;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.saxsys.mvvmfx.utils.notifications.NotificationCenter;
import io.docker.ui.services.OrderDeliveryDataService;
import io.docker.ui.services.TabService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;

import java.net.URL;
import java.util.ResourceBundle;
import javax.inject.Inject;

/**
 * @author sascha on 02/12/15.
 */
public class OrderView implements FxmlView<OrderViewModel>, Initializable {

    @Inject
    private TabService tabService;

    @Inject
    private OrderDeliveryDataService dataService;

    @FXML
    // Injection of the application which is declared in the FXML File
    private Tab orderView; // Value injected by FXMLLoader

    @InjectViewModel
    private OrderViewModel viewModel;

    @Inject
    private OrderItemViewModel itemViewModel;

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
    private Button saveButton;

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
            //todo show modal dialog with error message
        }

    }

    private boolean valid() {
        return true;
    }

}
