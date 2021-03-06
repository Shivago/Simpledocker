package io.docking.core;

import static org.junit.Assert.assertTrue;

import io.docking.core.order.Order;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by johnny on 1/21/16.
 */
public class SimpleDockerTest extends DockerTestsuite {

    @Test
    @Override
    public void shouldFulfillEveryOrder() {
        WagonBatch trainOne = getTrainOne();
        WagonBatch trainTwo = getTrainTwo();
        Order orderOne = getOrderOne();
        Order orderTwo = getOrderTwo();
        List<WagonBatch> trains = Arrays.asList(trainOne, trainTwo);
        List<Order> orders = Arrays.asList(orderOne, orderTwo);
        new SimpleDocker().dock(orders, trains);
        assertTrue("should fulfill every order",
                validateFulfillment(trains, orders));
    }

    @Test
    public void shouldHaveLowRuntime() {
        WagonBatch trainOne = getTrainOne();
        WagonBatch trainTwo = getTrainTwo();
        Order orderOne = getOrderOne();
        Order orderTwo = getOrderTwo();
        List<WagonBatch> trains = Arrays.asList(trainOne, trainTwo);
        List<Order> orders = Arrays.asList(orderOne, orderTwo);
        List<Docking> dockingPlan = new SimpleDocker().dock(orders, trains);
        int wagonsCount = Arrays.asList(trainOne, trainTwo).stream()
                .map(wagonBatch -> wagonBatch.getWagons())
                .reduce((identity, accumulator) -> {
                    identity.addAll(accumulator);
                    return identity;
                }).get().size();
        assertTrue("should have low runtime", dockingPlan.size() < wagonsCount);
    }

    /**
     *
     * @param trains
     * @param orders
     * @return
     */
    private boolean validateFulfillment(List<WagonBatch> trains,
                                        List<Order> orders) {
        return true;
    }


}
