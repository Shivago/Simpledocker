package io.docker.ui;

import de.saxsys.mvvmfx.guice.MvvmfxGuiceApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends MvvmfxGuiceApplication {

    @Override
    public void startMvvmfx(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/templates/Application.fxml"));
        Scene mainScene = new Scene(root, 1080, 960);
        primaryStage.setMinHeight(900.0);
        primaryStage.setMinWidth(1024.0);
        String materialCss = getClass().getResource("/css/material.css").toExternalForm();
        mainScene.getStylesheets().add(materialCss);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Simple Docker™ v0.1.0");
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
