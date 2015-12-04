package io.docker.ui.view.order;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import io.docker.ui.viewmodel.order.OrderSelectionListViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author sascha on 02/12/15.
 */
public class OrderSelectionListView implements FxmlView<OrderSelectionListViewModel>, Initializable {

    @FXML
    // Injection of the application which is declared in the FXML File
    private HBox orderItemViewOne, orderItemViewTwo, orderItemViewThree, orderItemViewFour, orderItemViewFive; // Value injected by FXMLLoader

    @InjectViewModel
    private OrderSelectionListViewModel viewModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
