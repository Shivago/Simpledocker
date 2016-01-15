package io.docker.ui;

import com.google.inject.Module;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import de.saxsys.mvvmfx.guice.MvvmfxGuiceApplication;
import io.docker.ui.view.application.ApplicationView;
import io.docker.ui.view.application.ApplicationViewModel;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.List;

/**
 * @author sascha on 02/12/15.
 */
public class Application extends MvvmfxGuiceApplication {

    @Override
    public void startMvvmfx(final Stage stage) throws Exception {

        ViewTuple<ApplicationView, ApplicationViewModel> tuple =
                FluentViewLoader.fxmlView(ApplicationView.class).load();

        // Locate View for loaded FXML file
        final Parent view = tuple.getView();

        final Scene scene = new Scene(view, 1080.0, 960.0);

        String materialCss = getClass().getResource("/css/material.css").toExternalForm();
        scene.getStylesheets().add(materialCss);

        stage.setScene(scene);
        stage.setTitle("Simple Docker™ v0.2.0");
        stage.getIcons().add(new Image("/images/simple_docker_icon.png"));
        stage.show();
    }

    @Override
    public void initGuiceModules(List<Module> modules) throws Exception {
        modules.add(new GuiceModule());
    }

    public static void main(final String[] args) {
        launch(args);
    }

}
