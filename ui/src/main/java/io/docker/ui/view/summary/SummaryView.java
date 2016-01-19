package io.docker.ui.view.summary;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.saxsys.mvvmfx.utils.notifications.NotificationCenter;
import io.docker.ui.services.OrderDeliveryDataService;
import io.docker.ui.services.TabService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Sascha Ormanns on 02/12/15.
 *
 * Controller class for the file OrderItemView.fxml,
 * which represents the graphical user interface
 * By convention the ...Controller is omitted
 *
 */
public class SummaryView implements FxmlView<SummaryViewModel>, Initializable {

    private final NotificationCenter notificationCenter;

    private final TabService tabService;

    private final OrderDeliveryDataService orderDeliveryDataService;

    @FXML
    // Injection of the application which is declared in the FXML File
    private Tab summaryView; // Value injected by FXMLLoader

    @InjectViewModel
    private SummaryViewModel viewModel;

    @FXML
    private TextArea summary;

    @FXML
    private Button saveButton;

    @FXML
    private Button printButton;

    @Inject
    public SummaryView(NotificationCenter notificationCenter,
                      TabService tabService,
                      OrderDeliveryDataService orderDeliveryDataService) {
        this.notificationCenter = notificationCenter;
        this.tabService = tabService;
        this.orderDeliveryDataService = orderDeliveryDataService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void saveButtonPressed(final ActionEvent event) {
        System.out.println("summary save button pressed...");
    }

    @FXML
    void printButtonPressed(final ActionEvent event) {
        viewModel.printSummary(summary, event);
    }

}
