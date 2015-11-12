package io.docker.ui.components;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

import java.io.IOException;

/**
 * Created by johnny on 11/10/15.
 */
public class OrderSelectionList extends HBox {

    public OrderSelectionList() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                .getResource("/templates/components/OrderSelectionList.fxml"));
        fxmlLoader.setController(new OrderSelectionListController());
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

}
