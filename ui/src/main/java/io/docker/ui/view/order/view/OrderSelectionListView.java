package io.docker.ui.view.order.view;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import io.docker.ui.view.order.viewmodel.OrderSelectionListViewModel;
import io.docking.core.order.OrderItem;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author Sascha Ormanns on 02/12/15.
 */
public class OrderSelectionListView implements FxmlView<OrderSelectionListViewModel>, Initializable {

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
        orderItemViewOneController.selectIndex(0);
        orderItemViewTwoController.selectIndex(1);
        orderItemViewThreeController.selectIndex(2);
        orderItemViewFourController.selectIndex(3);
        orderItemViewFiveController.selectIndex(4);

        viewModel.orderItem1Property().bind(orderItemViewOneController.getViewModel().getOrderItemProperty());
        viewModel.orderItem2Property().bind(orderItemViewTwoController.getViewModel().getOrderItemProperty());
        viewModel.orderItem3Property().bind(orderItemViewThreeController.getViewModel().getOrderItemProperty());
        viewModel.orderItem4Property().bind(orderItemViewFourController.getViewModel().getOrderItemProperty());
        viewModel.orderItem5Property().bind(orderItemViewFiveController.getViewModel().getOrderItemProperty());
    }

    public void setSelectionListHeading(String text) {
        selectionListHeading.setText(text);
    }

    public List<OrderItem> getOrderItems() {
        return Arrays.asList(
            viewModel.orderItem1Property().getValue(),
            viewModel.orderItem2Property().getValue(),
            viewModel.orderItem3Property().getValue(),
            viewModel.orderItem4Property().getValue(),
            viewModel.orderItem5Property().getValue()
        );
    }

    public OrderSelectionListViewModel getViewModel() {
        return viewModel;
    }
}
