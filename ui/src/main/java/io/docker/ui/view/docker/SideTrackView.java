package io.docker.ui.view.docker;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import io.docking.core.order.Product;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author Sascha Ormanns on 02/12/15.
 *
 * Controller class for the file SideTrackView.fxml,
 * which represents the graphical user interface
 * By convention the ...Controller is omitted
 *
 */
public class SideTrackView implements FxmlView<SideTrackViewModel>, Initializable {

    @FXML
    // Injection of the application which is declared in the FXML File
    private VBox sideTrackView; // Value injected by FXMLLoader

    @FXML
    private ListView sideTrackListView;

    private SimpleListProperty<Product> sideTrackPropertyList;

    private List<Product> cache;

    @InjectViewModel
    private SideTrackViewModel viewModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sideTrackPropertyList = new SimpleListProperty<>();
        cache = new ArrayList<>();
        sideTrackListView.itemsProperty().bindBidirectional(sideTrackPropertyList);
        sideTrackPropertyList.bindBidirectional(viewModel.sideTrackPropertyListProperty());
    }

    public void addProductToSideTrack(Product product) {
        cache.add(product);
        sideTrackListView.setItems(FXCollections.observableArrayList(cache));
    }

}
