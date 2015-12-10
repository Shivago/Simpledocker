package io.docker.ui.view.order;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import io.docker.ui.viewmodel.order.OrderSelectionListViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author sascha on 02/12/15.
 */
public class OrderSelectionListView implements FxmlView<OrderSelectionListViewModel>, Initializable {

    @FXML
    private Label selectionListHeading;

    @FXML
    // Injection of the application which is declared in the FXML File
    private Parent orderItemViewOne, orderItemViewTwo, orderItemViewThree, orderItemViewFour, orderItemViewFive; // Value injected by FXMLLoader

    @FXML
    private OrderItemView orderItemViewOneController, orderItemViewTwoController, orderItemViewThreeController, orderItemViewFourController, orderItemViewFiveController;

    @InjectViewModel
    private OrderSelectionListViewModel viewModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setSelectionListHeading(String text) {
        selectionListHeading.setText(text);
    }

    public OrderSelectionListViewModel getViewModel() {
        return viewModel;
    }

    public List<ComboBox> getAllComboboxes() {
        List<ComboBox> comboBoxes = new ArrayList<>(Arrays.asList(
                orderItemViewOneController.getComboBox(),
                orderItemViewTwoController.getComboBox(),
                orderItemViewThreeController.getComboBox(),
                orderItemViewFourController.getComboBox(),
                orderItemViewFiveController.getComboBox()
        ));
        return comboBoxes;
    }

}
