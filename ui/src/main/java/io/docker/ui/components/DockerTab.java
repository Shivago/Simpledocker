package io.docker.ui.components;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;

import java.io.IOException;

/**
 * @author sascha on 14/11/15.
 */
public class DockerTab extends Tab {

    public DockerTab() {
        super("Docking");
        init();
    }

    private void init() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                .getResource("/templates/views/DockerTab.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
