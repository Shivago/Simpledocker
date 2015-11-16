package io.docker.ui.components;

import com.jfoenix.controls.JFXButton;
import io.docking.core.order.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

/**
 * Created by johnny on 11/10/15.
 */
public class OrderSelectionListController {

    @FXML
    private ComboBox o1_prod1, o1_prod2, o1_prod3, o1_prod4, o1_prod5;
    private ComboBox[] comboBoxList;

    @FXML
    private JFXButton resetButton;

    @FXML
    private JFXButton saveButton;

    @FXML
    public void initialize() {
        //initComboBoxes();
        //initRestButton();
        //initSaveButton();
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

    private void initRestButton() {
        resetButton.getStyleClass().add("button-outline");
    }

    private void initSaveButton() {
        saveButton.getStyleClass().add("button-raised");
    }



}
