package io.docker.ui.view.docker;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.saxsys.mvvmfx.utils.notifications.NotificationCenter;
import io.docker.ui.services.OrderDeliveryDataService;
import io.docker.ui.services.TabService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;
import javax.inject.Inject;

/**
 * @author sascha on 02/12/15.
 */
public class DockerView implements FxmlView<DockerViewModel>, Initializable {

    @Inject
    private NotificationCenter notificationCenter;

    @Inject
    private TabService tabService;

    @Inject
    private OrderDeliveryDataService orderDeliveryDataService;

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
    private VBox sideTrackView1, sideTrackView2, sideTrackView3, sideTrackView4, sideTrackView5;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        notificationCenter.subscribe("saved", (s, objects) -> {
            System.out.println("New data boiii!");
            OrderDeliveryDataService.OrderDeliveryData data = orderDeliveryDataService.getData();
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
    void stopButtonPressed(final ActionEvent event) {
        System.out.println("stop button pressed...");
    }

    @FXML
    void playButtonPressed(final ActionEvent event) {
        System.out.println("play button pressed...");
    }

}
