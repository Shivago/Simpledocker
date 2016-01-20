package io.docker.ui.view.docker;

import de.saxsys.mvvmfx.ViewModel;
import io.docking.core.order.Product;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;

import javax.inject.Inject;

/**
 * @author Sascha Ormanns on 02/12/15.
 */
public class SideTrackViewModel implements ViewModel {

    private SimpleListProperty<Product> sideTrackPropertyList = new SimpleListProperty<>();

    private SideTrackModel sideTrackModel;

    @Inject
    public SideTrackViewModel(SideTrackModel sideTrackModel) {
        this.sideTrackModel = sideTrackModel;
        sideTrackPropertyList.bindBidirectional(sideTrackModel.sideTrackPropertyListProperty());
    }

    public ObservableList<Product> getSideTrackPropertyList() {
        return sideTrackPropertyList.get();
    }

    public SimpleListProperty<Product> sideTrackPropertyListProperty() {
        return sideTrackPropertyList;
    }

    public void setSideTrackPropertyList(ObservableList<Product> sideTrackPropertyList) {
        this.sideTrackPropertyList.set(sideTrackPropertyList);
    }
}
