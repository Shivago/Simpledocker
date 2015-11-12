package io.docker.ui.components;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;

import java.io.IOException;

/**
 * Created by johnny on 11/10/15.
 */
public class OrderTab extends Tab {

    public OrderTab() {
        super("Order");
        init();
    }

    private void init() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                .getResource("/templates/views/OrderTab.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }


}