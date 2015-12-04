package io.docker.ui.view.order;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import io.docker.ui.viewmodel.order.OrderViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author sascha on 02/12/15.
 */
public class OrderView implements FxmlView<OrderViewModel>, Initializable {

    @FXML
    // Injection of the application which is declared in the FXML File
    private Tab orderView; // Value injected by FXMLLoader

    @InjectViewModel
    private OrderViewModel viewModel;

    @FXML
    private HBox orderSeletionListViewOne, orderSelectionListViewTwo;

    @FXML
    private Button saveButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void saveButtonPressed(final ActionEvent event) {
        System.out.println("save button pressed...");
    }

}
