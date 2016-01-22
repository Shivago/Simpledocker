package io.docker.ui.view.order;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import io.docker.ui.viewmodel.order.OrderViewModel;
import io.docking.core.order.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author sascha on 02/12/15.
 */
public class OrderView implements FxmlView<OrderViewModel>, Initializable {

    @FXML
    // Injection of the application which is declared in the FXML File
    private Tab orderView; // Value injected by FXMLLoader

    @InjectViewModel
    private OrderViewModel viewModel;

    @FXML
    private Parent orderSelectionListViewOne, orderSelectionListViewTwo, orderSelectionListViewThree, orderSelectionListViewFour;

    @FXML
    private OrderSelectionListView orderSelectionListViewOneController, orderSelectionListViewTwoController, orderSelectionListViewThreeController, orderSelectionListViewFourController;

    @FXML
    private Button saveButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        orderSelectionListViewOneController.setSelectionListHeading("Koblenz");
        orderSelectionListViewTwoController.setSelectionListHeading("Neuss");
        orderSelectionListViewThreeController.setSelectionListHeading("Liége");
        orderSelectionListViewFourController.setSelectionListHeading("Maastricht");
        initOrderSelectionLists();
        setOrderListDefaultValues();
    }

    private void initOrderSelectionLists() {
        List<OrderSelectionListView> listViews = new ArrayList<>(
                Arrays.asList(orderSelectionListViewOneController,
                              orderSelectionListViewTwoController,
                              orderSelectionListViewThreeController,
                              orderSelectionListViewFourController));
        List<Product> productList;
        List<ComboBox> comboBoxes;

        for (OrderSelectionListView view : listViews) {
            productList = getProductListFrom(view);
            comboBoxes = view.getAllComboboxes();
            for (ComboBox box : comboBoxes) {
                for (Product product : productList) {
                    box.getItems().add(product.toString());
                }
            }
        }
    }

    public void setOrderListDefaultValues() {
        List<OrderSelectionListView> listViews = new ArrayList<>(
                Arrays.asList(orderSelectionListViewOneController,
                        orderSelectionListViewTwoController));
        List<Product> productList;
        List<ComboBox> comboBoxes;

        for (OrderSelectionListView view : listViews) {
            productList = getProductListFrom(view);
            comboBoxes = view.getAllComboboxes();
            for (int i = 0; i < productList.size(); i++) {
                comboBoxes.get(i).setValue(productList.get(i));
            }

        }

    }

    private List<Product> getProductListFrom(OrderSelectionListView view) {
        return view.getViewModel().getProductList();
    }

    @FXML
    void saveButtonPressed(final ActionEvent event) {
        System.out.println("save button pressed...");
    }

}
