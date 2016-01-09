package io.docker.ui.view.order;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import io.docker.ui.ServiceController;
import io.docker.ui.viewmodel.order.OrderSelectionListViewModel;
import io.docking.core.order.OrderItem;
import io.docking.core.order.Product;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import javax.inject.Inject;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author sascha on 02/12/15.
 */
public class OrderSelectionListView implements FxmlView<OrderSelectionListViewModel>, Initializable {

    @Inject
    private ServiceController serviceController;

    @FXML
    private Label selectionListHeading;

    @FXML
    private Parent orderItemViewOne;

    @FXML
    private Parent orderItemViewTwo;

    @FXML
    private Parent orderItemViewThree;

    @FXML
    private Parent orderItemViewFour;

    @FXML
    private Parent orderItemViewFive;

    @FXML
    private OrderItemView orderItemViewOneController;

    @FXML
    private OrderItemView orderItemViewTwoController;

    @FXML
    private OrderItemView orderItemViewThreeController;

    @FXML
    private OrderItemView orderItemViewFourController;

    @FXML
    private OrderItemView orderItemViewFiveController;

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

    public List<ComboBox<Product>> getAllComboboxes() {
        List<ComboBox<Product>> comboBoxes = new ArrayList<>(Arrays.asList(
                orderItemViewOneController.getComboBox(),
                orderItemViewTwoController.getComboBox(),
                orderItemViewThreeController.getComboBox(),
                orderItemViewFourController.getComboBox(),
                orderItemViewFiveController.getComboBox()
        ));
        return comboBoxes;
    }

    public List<OrderItem> getOrderItems() {
        List<OrderItem> items = new ArrayList<>(Arrays.asList(
                new OrderItem(orderItemViewOneController.getComboBox().getValue(),
                        Integer.valueOf(orderItemViewOneController.getTextField().getText())),
                new OrderItem(orderItemViewTwoController.getComboBox().getValue(),
                        Integer.valueOf(orderItemViewTwoController.getTextField().getText())),
                new OrderItem(orderItemViewThreeController.getComboBox().getValue(),
                        Integer.valueOf(orderItemViewThreeController.getTextField().getText())),
                new OrderItem(orderItemViewFourController.getComboBox().getValue(),
                        Integer.valueOf(orderItemViewFourController.getTextField().getText())),
                new OrderItem(orderItemViewFiveController.getComboBox().getValue(),
                        Integer.valueOf(orderItemViewFiveController.getTextField().getText()))
        ));

        return items;
    }
}
