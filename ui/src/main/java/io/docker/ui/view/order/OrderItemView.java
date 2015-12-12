package io.docker.ui.view.order;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import io.docker.ui.viewmodel.order.OrderItemViewModel;
import io.docking.core.order.OrderItem;
import io.docking.core.order.Product;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author sascha on 02/12/15.
 */
public class OrderItemView implements FxmlView<OrderItemViewModel>, Initializable {

    @FXML
    private ComboBox<Product> comboBox;

    @FXML
    private TextField textField;

    @FXML
    private HBox orderItemView;

    @InjectViewModel
    private OrderItemViewModel viewModel;

    public OrderItemView(){}

    public OrderItemView(ComboBox<Product> comboBox, TextField textField, OrderItemViewModel viewModel) {
        this.comboBox = comboBox;
        this.textField = textField;
        this.viewModel = viewModel;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            //todo validate input
            viewModel.getAmountProperty().setValue(Integer.valueOf(newValue));
        });
        comboBox.valueProperty().bindBidirectional(viewModel.getProductProperty());
    }

    public ComboBox<Product> getComboBox() {
        return comboBox;
    }


}
