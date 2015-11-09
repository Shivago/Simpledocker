package io.docking.core;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by johnny on 11/7/15.
 */
public class WagonBatchTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfParameterNull() {
        WagonBatch.parse(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfParameterEmpty() {
        WagonBatch.parse("");
    }

    @Test
    public void wagonListInTheSameOrderAsTheInput() {
        WagonBatch wagonBatch = WagonBatch.parse("ABBBCC");
        Assert.assertTrue(wagonBatch.getWagons().get(0).getProduct().getName().equals("A"));
        Assert.assertTrue(wagonBatch.getWagons().get(1).getProduct().getName().equals("B"));
        Assert.assertTrue(wagonBatch.getWagons().get(2).getProduct().getName().equals("B"));
        Assert.assertTrue(wagonBatch.getWagons().get(3).getProduct().getName().equals("B"));
        Assert.assertTrue(wagonBatch.getWagons().get(4).getProduct().getName().equals("C"));
        Assert.assertTrue(wagonBatch.getWagons().get(5).getProduct().getName().equals("C"));
    }

    @Test
    public void wagonListInTheSameSizeAsTheInput() {
        String input = "ABBBCC";
        WagonBatch wagonBatch = WagonBatch.parse(input);
        Assert.assertTrue(wagonBatch.getWagons().size() == input.length());
    }

}
