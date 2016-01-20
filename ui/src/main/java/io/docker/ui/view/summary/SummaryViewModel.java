package io.docker.ui.view.summary;

import de.saxsys.mvvmfx.ViewModel;
import io.docking.core.Docking;
import io.docking.core.DockingPlan;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.util.List;


/**
 * @author Sascha Ormanns on 02/12/15.
 */
public class SummaryViewModel implements ViewModel {

    public SummaryViewModel() {}

    public void addTextAreaContent(TextArea textArea, DockingPlan dockingPlan) {
        List<Docking> dockingList = dockingPlan.getDockings();

        for (Docking d : dockingList) {
            textArea.appendText(d.toString());
            textArea.appendText(System.getProperty("line.separator"));
        }
    }

    public void printSummary(TextArea textArea, ActionEvent event) {
        // todo implement
        System.out.println();
    }

}
