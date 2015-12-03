package io.docker.ui.view.summary;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import io.docker.ui.viewmodel.summary.SummaryViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author sascha on 02/12/15.
 */
public class SummaryView implements FxmlView<SummaryViewModel>, Initializable {

    @FXML
    // Injection of the application which is declared in the FXML File
    private Tab summaryView; // Value injected by FXMLLoader

    @InjectViewModel
    private SummaryViewModel viewModel;

    @FXML
    private Button saveButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void saveButtonPressed(final ActionEvent event) {
        System.out.println("summary save button pressed...");
    }

}
