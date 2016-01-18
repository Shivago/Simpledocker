package io.docker.ui.view.summary;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import de.saxsys.mvvmfx.ViewModel;
import io.docking.core.Docking;
import io.docking.core.DockingPlan;
import javafx.event.ActionEvent;
import javafx.print.PrinterJob;
import javafx.scene.Node;
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
