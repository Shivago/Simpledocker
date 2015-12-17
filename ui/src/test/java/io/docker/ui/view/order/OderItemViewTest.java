package io.docker.ui.view.order;

import io.docker.ui.GuiceStarter;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;

/**
 * Created by johnny on 12/11/15.
 */
public class OderItemViewTest extends FxRobot {

    @Before
    public void setupApp() throws Exception {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(GuiceStarter.class);
    }

    @Test
    public void shouldReturnTheRightOrderItem() {

    }

}
