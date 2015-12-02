package io.docker.ui.view.application;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import io.docker.ui.view.docker.DockerView;
import io.docker.ui.view.order.OrderView;
import io.docker.ui.view.summary.SummaryView;
import io.docker.ui.viewmodel.application.ApplicationViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author sascha on 02/12/15.
 */
public class ApplicationView implements FxmlView<ApplicationViewModel>, Initializable {

    @FXML
    // Injection of the application which is declared in the FXML File
    private AnchorPane applicationView; // Value injected by FXMLLoader

    @InjectViewModel
    private ApplicationViewModel viewModel;

    @FXML
    // Inject the Code behind instance of the orderView by using the
    // nameconvention ...Controller
    private OrderView orderViewController;

    @FXML
    // Inject the Code behind instance of the dockerView by using the
    // nameconvention ...Controller
    private DockerView dockerViewController;

    @FXML
    // Inject the Code behind instance of the summaryView by using the
    // nameconvention ...Controller
    private SummaryView summaryViewController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
