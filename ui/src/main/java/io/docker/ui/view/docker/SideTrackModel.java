package io.docker.ui.view.docker;

import io.docking.core.order.Product;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;

/**
 * Created by Sascha Ormanns on 19.01.16.
 */
public class SideTrackModel {

    private SimpleListProperty<Product> sideTrackPropertyList;

    public SideTrackModel() {
        sideTrackPropertyList = new SimpleListProperty<>();
    }

    public boolean appendOrderItemToSideTrack(Product product) {
        return sideTrackPropertyList.add(product);
    }

    public boolean removeOrderItemFromSideTrack(Product product) {
        if (sideTrackPropertyList.contains(product)) {
            return sideTrackPropertyList.remove(product);
        }
        return false;
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
