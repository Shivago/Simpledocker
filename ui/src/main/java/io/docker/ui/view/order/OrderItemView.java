package io.docker.ui.view.order;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.saxsys.mvvmfx.utils.notifications.NotificationCenter;
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
 * @author Sascha Ormanns on 02/12/15.
 *
 * Controller class for the file OrderItemView.fxml,
 * which represents the graphical user interface
 * By convention the ...Controller is omitted
 *
 */
public class OrderItemView implements FxmlView<OrderItemViewModel>, Initializable {

    private final ProductService productService;

    private final NotificationCenter notificationCenter;

    @FXML
    private ComboBox<Product> comboBox;

    @FXML
    private TextField textField;

    @FXML
    private HBox orderItemView;

    @InjectViewModel
    private OrderItemViewModel viewModel;

    @Inject
    public OrderItemView(ProductService productService,
                         NotificationCenter notificationCenter) {
        this.productService = productService;
        this.notificationCenter = notificationCenter;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!isInteger(newValue)) { newValue = ""; }
            textField.textProperty().unbind();
            textField.textProperty().set(newValue);
            if (newValue != "") {
                viewModel.getAmountProperty().set(Integer.valueOf(textField.textProperty().get()));
                notificationCenter.publish("datachanged");
                generateOrderItem();
            }
        });
        comboBox.valueProperty().addListener(observable -> {
            notificationCenter.publish("datachanged");
            comboBox.valueProperty().unbind();
            viewModel.getProductProperty().setValue(comboBox.valueProperty().get());
            generateOrderItem();
        });
        notificationCenter.publish("datachanged");
        textField.textProperty().bind(viewModel.getAmountProperty().asString());
        comboBox.valueProperty().bind(viewModel.getProductProperty());
        comboBox.setItems(productService.getProductsAsOrderItemObservableList());
        generateOrderItem();
    }

    public boolean isInteger(String str) {
        try {
            Integer.valueOf(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void selectIndex(int defaultIndex) {
        comboBox.getSelectionModel().select(defaultIndex);
        viewModel.getProductProperty().setValue(comboBox.getValue());
    }

    public void setProduct(int defaultIndex) {
        comboBox.getSelectionModel().select(defaultIndex);
    }

    private void generateOrderItem() {
        viewModel.getOrderItemProperty().setValue(new OrderItem(viewModel.getProduct(), viewModel.getAmount()));
    }

    public OrderItemViewModel getViewModel() {
        return viewModel;
    }
}
