package io.docker.ui.view.order;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import io.docker.ui.viewmodel.order.OrderItemViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author sascha on 02/12/15.
 */
public class OrderItemView implements FxmlView<OrderItemViewModel>, Initializable {

    @FXML
    // Injection of the application which is declared in the FXML File
    private HBox orderItemView; // Value injected by FXMLLoader

    @InjectViewModel
    private OrderItemViewModel viewModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
