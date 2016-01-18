package io.docker.ui.view.docker;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Sascha Ormanns on 02/12/15.
 */
public class SideTrackView implements FxmlView<SideTrackViewModel>, Initializable {

    @FXML
    // Injection of the application which is declared in the FXML File
    private VBox sideTrackView; // Value injected by FXMLLoader

    @InjectViewModel
    private SideTrackViewModel viewModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
