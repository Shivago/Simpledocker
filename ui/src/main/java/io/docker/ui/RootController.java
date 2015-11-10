package io.docker.ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import io.docking.core.order.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;

/**
 * @author sascha
 */
public class RootController {

    @FXML
    private ComboBox o1_prod1, o1_prod2, o1_prod3, o1_prod4, o1_prod5;
    private ComboBox[] comboBoxList;

    @FXML
    private JFXButton buttonOk;

    @FXML
    private JFXTabPane tabPane;

    public RootController() {

    }

    @FXML
    public void initialize() {
        initComboBoxes();
        initButtonOk();
    }


    public void initButtonOk() {
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        buttonOk.setOnMouseClicked(e -> selectionModel.select(2));
    }


    /**
     * initializes the order combo boxes
     */
    public void initComboBoxes() {
        comboBoxList = new ComboBox[]{o1_prod1, o1_prod2, o1_prod3, o1_prod4, o1_prod5};
        ObservableList<Product> options =
                FXCollections.observableArrayList(
                        new Product("NB", "MacBook Pro"),
                        new Product("PC", "Mac Pro"),
                        new Product("MP", "iPhone 6s"),
                        new Product("AW", "Apple Watch"),
                        new Product("TB", "iPad")
                );
        for (ComboBox box : comboBoxList) {
            box.setItems(options);
        }
    }
}
