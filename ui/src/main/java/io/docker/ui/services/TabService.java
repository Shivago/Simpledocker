package io.docker.ui.services;

import javafx.scene.control.TabPane;

import javax.inject.Singleton;

/**
 * Service to change to tabs of the application
 */
@Singleton
public class TabService {

    private TabPane tabPane;

    public void setTabPane(TabPane tabPane) {
        this.tabPane = tabPane;
    }

    /**
     * Change active tab to the given index
     *
     * @param index index of the destination view
     */
    public void changeToTab(int index) {
        tabPane.getSelectionModel().select(index);
    }

}
