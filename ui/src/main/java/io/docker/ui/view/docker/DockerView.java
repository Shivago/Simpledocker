package io.docker.ui.view.docker;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import io.docker.ui.viewmodel.docker.DockerViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author sascha on 02/12/15.
 */
public class DockerView implements FxmlView<DockerViewModel>, Initializable {

    @FXML
    // Injection of the application which is declared in the FXML File
    private Tab dockerView; // Value injected by FXMLLoader

    @InjectViewModel
    private DockerViewModel viewModel;

    @FXML
    private Button backButton, nextButton, stopButton, playButton;

    @FXML
    private VBox sideTrackView1, sideTrackView2, sideTrackView3, sideTrackView4, sideTrackView5;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void backButtonPressed(final ActionEvent event) {
        System.out.println("back button pressed...");
    }

    @FXML
    void nextButtonPressed(final ActionEvent event) {
        System.out.println("next button pressed...");
    }

    @FXML
    void stopButtonPressed(final ActionEvent event) {
        System.out.println("stop button pressed...");
    }

    @FXML
    void playButtonPressed(final ActionEvent event) {
        System.out.println("play button pressed...");
    }

}
