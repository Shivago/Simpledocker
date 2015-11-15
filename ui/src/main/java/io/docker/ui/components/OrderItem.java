package io.docker.ui.components;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

import java.io.IOException;

/**
 * @author sascha on 13/11/15.
 */
public class OrderItem extends HBox{

    public OrderItem() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                .getResource("/templates/components/OrderItem.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
