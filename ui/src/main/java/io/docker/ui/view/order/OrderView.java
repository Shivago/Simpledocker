package io.docker.ui.view.order;

import com.jfoenix.controls.JFXButton;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.saxsys.mvvmfx.utils.notifications.NotificationCenter;
import io.docker.ui.services.OrderDeliveryDataService;
import io.docker.ui.services.TabService;
import io.docking.core.order.OrderItem;
import io.docking.core.order.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.inject.Inject;

/**
 * @author Sascha Ormanns on 02/12/15.
 *         <p>
 *         Controller class for the file OrderView.fxml,
 *         which represents the graphical user interface
 *         By convention the ...Controller is omitted
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
    // Inject the Code behind instance of the orderView by using the
    // name convention ...Controller
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
        Map<Product, Integer> orderAmounts = createProductToAmountMap(orderSelectionListViewOneController.getOrderItems(),
                orderSelectionListViewTwoController.getOrderItems());
        Map<Product, Integer> deliveryAmounts = createProductToAmountMap(orderSelectionListViewThreeController.getOrderItems(),
                orderSelectionListViewFourController.getOrderItems());

        if (sumAmount(orderSelectionListViewOneController.getOrderItems()) <= maxAmount
                && sumAmount(orderSelectionListViewTwoController.getOrderItems()) <= maxAmount
                && sumAmount(orderSelectionListViewThreeController.getOrderItems()) <= maxAmount
                && sumAmount(orderSelectionListViewFourController.getOrderItems()) <= maxAmount
                && orderAmountEqualsDeliveryAmount(orderAmounts, deliveryAmounts)) {
            return true;
        }
        return false;
    }

    public Map<Product, Integer> createProductToAmountMap(List<OrderItem> orderItemListOne, List<OrderItem> orderItemListTwo) {
        Map<Product, Integer> orderMap = new HashMap<>();
        int counter = 0;

        for (int i = 0; i < orderItemListOne.size() && orderItemListOne.size() == orderItemListTwo.size(); i++) {
            counter += orderItemListOne.get(i).getAmount();
            orderMap.put(orderItemListOne.get(i).getProduct(), counter);
            counter += orderItemListTwo.get(i).getAmount();
            orderMap.put(orderItemListTwo.get(i).getProduct(), counter);
            counter = 0;
        }
        return orderMap;
    }

    public int sumAmount(List<OrderItem> orderItemList) {
        int sum = 0;
        for (OrderItem item : orderItemList) {
            sum += item.getAmount();
        }
        return sum;
    }

    public boolean orderAmountEqualsDeliveryAmount(Map<Product, Integer> orderAmounts, Map<Product, Integer> deliveryAmounts) {
        for (Map.Entry<Product, Integer> entry : orderAmounts.entrySet()) {
            Product key = entry.getKey();
            Integer amount1 = entry.getValue();
            Integer amount2 = deliveryAmounts.get(key);
            if (amount1 != amount2) {
                return false;
            }
        }
        return true;
    }

}
