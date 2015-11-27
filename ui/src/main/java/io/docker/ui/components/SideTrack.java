package io.docker.ui.components;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * @author sascha on 16/11/15.
 */
public class SideTrack extends VBox {

    public SideTrack() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                .getResource("/templates/components/SideTrack.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

}
