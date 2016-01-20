package io.docker.ui.view.application;

import com.jfoenix.controls.JFXTabPane;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import io.docker.ui.services.TabService;
import io.docker.ui.view.docker.DockerView;
import io.docker.ui.view.order.OrderView;
import io.docker.ui.view.summary.SummaryView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;
import javax.inject.Inject;

/**
 * @author Sascha Ormanns on 02/12/15.
 *
 * Controller class for the file ApplicationView.fxml,
 * which represents the graphical user interface
 * By convention the ...Controller is omitted
 *
 */
public class ApplicationView implements FxmlView<ApplicationViewModel>, Initializable {

    private final TabService tabService;

    @FXML
    private AnchorPane applicationView;

    @InjectViewModel
    private ApplicationViewModel viewModel;

    @FXML
    public JFXTabPane tabPane;

    @FXML
    public MenuBar applicationMenubar;

    @FXML
    // Inject the Code behind instance of the orderView by using the
    // name convention ...Controller
    private OrderView orderViewController;

    @FXML
    // Inject the Code behind instance of the dockerView by using the
    // name convention ...Controller
    private DockerView dockerViewController;

    @FXML
    // Inject the Code behind instance of the summaryView by using the
    // name convention ...Controller
    private SummaryView summaryViewController;

    @Inject
    public ApplicationView(TabService tabService) {
        this.tabService = tabService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tabService.setTabPane(tabPane);
        buildMenu();
    }

    private void buildMenu() {
        final Menu fileMenu = new Menu("Vorgang");
        final MenuItem loadItem = new MenuItem("laden..");
        final MenuItem saveItem = new MenuItem("speichern/exportieren..");
        final SeparatorMenuItem seperator = new SeparatorMenuItem();
        final MenuItem exitItem = new MenuItem("Programm verlassen");
        fileMenu.getItems().addAll(loadItem, saveItem, seperator, exitItem);
        applicationMenubar.getMenus().add(fileMenu);

        final Menu configMenu = new Menu("Eigenschaften");
        final MenuItem configLoadItem = new MenuItem("Produktdatenbank laden..");
        configMenu.getItems().addAll(configLoadItem);
        applicationMenubar.getMenus().addAll(configMenu);

    }

    public void openConfiguration() {

    }



}
