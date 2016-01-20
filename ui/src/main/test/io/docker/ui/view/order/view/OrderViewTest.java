package io.docker.ui.view.order.view;

import static org.junit.Assert.assertEquals;

import io.docker.ui.view.order.OrderView;
import io.docking.core.order.OrderItem;
import io.docking.core.order.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sascha Ormanns on 19.01.16.
 */
public class OrderViewTest {

    private OrderView orderView;

    @Before
    public void setUp() throws Exception {
        orderView = new OrderView(null, null);
    }

    @Test
    public void testSumAmount() throws Exception {
        List<OrderItem> orderItemList = new ArrayList<>();
        orderItemList.add(new OrderItem(new Product("TE","Test1"),4));
        orderItemList.add(new OrderItem(new Product("TE","Test2"),2));
        orderItemList.add(new OrderItem(new Product("TE","Test3"),14));
        assertEquals(20, orderView.sumAmount(orderItemList));

    }

    @Test
    public void orderAmountEqualsDeliveryAmountShouldReturnTrue() {
        Map<Product, Integer> orderAmounts = new HashMap<>();
        orderAmounts.put(new Product("TE","Test1"),5);
        orderAmounts.put(new Product("TT","Test2"),5);
        orderAmounts.put(new Product("TS","Test3"),5);

        Map<Product, Integer> deliveryAmounts = new HashMap<>();
        deliveryAmounts.put(new Product("TE","Test1"),5);
        deliveryAmounts.put(new Product("TT","Test2"),5);
        deliveryAmounts.put(new Product("TS","Test3"),5);

        assertEquals(true, orderView.orderAmountEqualsDeliveryAmount(orderAmounts,deliveryAmounts));

    }

    @Test
    public void orderAmountEqualsDeliveryAmountShouldReturnFalse() {
        Map<Product, Integer> orderAmounts = new HashMap<>();
        orderAmounts.put(new Product("TE","Test1"),1);
        orderAmounts.put(new Product("TT","Test2"),2);
        orderAmounts.put(new Product("TS","Test3"),3);

        Map<Product, Integer> deliveryAmounts = new HashMap<>();
        deliveryAmounts.put(new Product("TE","Test1"),5);
        deliveryAmounts.put(new Product("TT","Test2"),5);
        deliveryAmounts.put(new Product("TS","Test3"),5);

        assertEquals(false, orderView.orderAmountEqualsDeliveryAmount(orderAmounts,deliveryAmounts));

    }

}