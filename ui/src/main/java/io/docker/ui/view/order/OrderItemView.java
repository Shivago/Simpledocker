package io.docker.ui.view.order;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.saxsys.mvvmfx.utils.notifications.NotificationCenter;
import io.docker.ui.ServiceController;
import io.docker.ui.services.ProductService;
import io.docking.core.order.OrderItem;
import io.docking.core.order.Product;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;
import javax.inject.Inject;

/**
 * @author sascha on 02/12/15.
 */
public class OrderItemView implements FxmlView<OrderItemViewModel>, Initializable {

    @Inject
    private ServiceController serviceController;

    @Inject
    private ProductService productService;

    @Inject
    private NotificationCenter notificationCenter;

    @FXML
    private ComboBox<Product> comboBox;

    @FXML
    private TextField textField;

    @FXML
    private HBox orderItemView;

    @InjectViewModel
    private OrderItemViewModel viewModel;

    public OrderItemView(){}

    public OrderItemView(ComboBox<Product> comboBox, TextField textField,
                         OrderItemViewModel viewModel) {
        this.comboBox = comboBox;
        this.textField = textField;
        this.viewModel = viewModel;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            //todo validate number input
            viewModel.getAmountProperty().setValue(Integer.valueOf(newValue));
            notificationCenter.publish("datachanged");
            generateOrderItem();
        });
        comboBox.valueProperty().addListener(observable -> {
            notificationCenter.publish("datachanged");
            generateOrderItem();
        });
        comboBox.valueProperty().bindBidirectional(viewModel.getProductProperty());
        comboBox.setItems(productService.getProductsAsOrderItemObservableList());
        generateOrderItem();
    }

    public void selectIndex(int defaultIndex) {
        comboBox.getSelectionModel().select(defaultIndex);
    }

    private void generateOrderItem() {
        viewModel.getOrderItemProperty().setValue(new OrderItem(viewModel.getProduct(), viewModel.getAmount()));
    }

    public OrderItemViewModel getViewModel() {
        return viewModel;
    }
}
