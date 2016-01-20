package io.docker.ui.view.docker;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.saxsys.mvvmfx.utils.notifications.NotificationCenter;
import io.docker.ui.services.OrderDeliveryDataService;
import io.docker.ui.services.TabService;
import io.docking.core.order.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javax.inject.Inject;

/**
 * @author Sascha Ormanns on 02/12/15.
 *
 * Controller class for the file DockerView.fxml,
 * which represents the graphical user interface
 * By convention the ...Controller is omitted
 *
 */
public class DockerView implements FxmlView<DockerViewModel>, Initializable {

    private final NotificationCenter notificationCenter;

    private final TabService tabService;

    private final OrderDeliveryDataService orderDeliveryDataService;

    @FXML
    // Injection of the application which is declared in the FXML File
    private Tab dockerView; // Value injected by FXMLLoader

    @InjectViewModel
    private DockerViewModel viewModel;

    @FXML
    private ListView orderListOne, orderListTwo;

    @FXML
    private ListView deliveryOne, deliveryTwo;

    @FXML
    private Button backButton, nextButton, stopButton, playButton;

    @FXML
    private Parent sideTrackView1, sideTrackView2, sideTrackView3;

    @FXML
    // Inject the Code behind instance of the orderView by using the
    // name convention ...Controller
    private SideTrackView sideTrackView1Controller, sideTrackView2Controller, sideTrackView3Controller;

    @Inject
    public DockerView(NotificationCenter notificationCenter,
                      TabService tabService,
                      OrderDeliveryDataService orderDeliveryDataService) {
        this.notificationCenter = notificationCenter;
        this.tabService = tabService;
        this.orderDeliveryDataService = orderDeliveryDataService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        OrderDeliveryDataService.OrderDeliveryData data = orderDeliveryDataService.getData();
        notificationCenter.subscribe("saved", (s, objects) -> {
            viewModel.initOrderLists(orderListOne, orderListTwo);
            viewModel.initDeliveries(deliveryOne, deliveryTwo);
            viewModel.order1propertyListProperty().bindBidirectional(orderListOne.itemsProperty());
            viewModel.order2propertyListProperty().bindBidirectional(orderListOne.itemsProperty());
            viewModel.delivery1propertyListProperty().bindBidirectional(deliveryOne.itemsProperty());
            viewModel.delivery2propertyListProperty().bindBidirectional(deliveryTwo.itemsProperty());
        });
    }

    public ListView getOrderListOne() {
        return orderListOne;
    }

    public ListView getOrderListTwo() {
        return orderListTwo;
    }

    @FXML
    void backButtonPressed(final ActionEvent event) {
        tabService.changeToTab(0);
    }

    @FXML
    void nextButtonPressed(final ActionEvent event) {
        tabService.changeToTab(2);
    }

    @FXML
    void stepBackButtonPressed(final ActionEvent event) {

    }

    @FXML
    void stepForwardButtonPressed(final ActionEvent event) {
        // todo implement the algorithm steps correctly
        Product exampleProduct = new Product("MB", "MacBook Pro");
        List<Product> tempList = new ArrayList<>();

        for (Product p : viewModel.delivery1propertyListProperty()) {
            if (exampleProduct.equals(p)) {
                System.out.println(p);
                sideTrackView1Controller.addProductToSideTrack(p);
                tempList.add(p);
            }
        }
        viewModel.delivery1propertyListProperty().removeAll(tempList);
    }

}
