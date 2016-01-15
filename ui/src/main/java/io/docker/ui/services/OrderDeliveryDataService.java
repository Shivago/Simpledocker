package io.docker.ui.services;

import io.docking.core.order.OrderItem;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;

/**
 * Created by johnny on 1/9/16.
 */
@Singleton
public class OrderDeliveryDataService {

    public static class OrderDeliveryData {

        private List<OrderItem> order1 = new ArrayList<>();
        private List<OrderItem> order2 = new ArrayList<>();

        private List<OrderItem> delivery1 = new ArrayList<>();
        private List<OrderItem> delivery2 = new ArrayList<>();

        public List<OrderItem> getOrder1() {
            return new ArrayList<>(order1);
        }

        public List<OrderItem> getOrder2() {
            return new ArrayList<>(order2);
        }

        public List<OrderItem> getDelivery1() {
            return new ArrayList<>(delivery1);
        }

        public List<OrderItem> getDelivery2() {
            return new ArrayList<>(delivery2);
        }

        public OrderDeliveryData setOrder1(List<OrderItem> order1) {
            this.order1.clear();
            this.order1.addAll(order1);
            return this;
        }

        public OrderDeliveryData setOrder2(List<OrderItem> order2) {
            this.order2.clear();
            this.order2.addAll(order2);
            return this;
        }

        public OrderDeliveryData setDelivery1(List<OrderItem> delivery1) {
            this.delivery1.clear();
            this.delivery1.addAll(delivery1);
            return this;
        }

        public OrderDeliveryData setDelivery2(List<OrderItem> delivery2) {
            this.delivery2.clear();
            this.delivery2.addAll(delivery2);
            return this;
        }

    }

    private List<OrderItem> order1 = new ArrayList<>();
    private List<OrderItem> order2 = new ArrayList<>();
    private List<OrderItem> delivery1 = new ArrayList<>();
    private List<OrderItem> delivery2 = new ArrayList<>();

    public void setOrder1(List<OrderItem> order1) {
        this.order1.clear();
        this.order1.addAll(order1);
    }

    public void setOrder2(List<OrderItem> order2) {
        this.order2.clear();
        this.order2.addAll(order2);
    }

    public void setDelivery1(List<OrderItem> delivery1) {
        this.delivery1.clear();
        this.delivery1.addAll(delivery1);
    }

    public void setDelivery2(List<OrderItem> delivery2) {
        this.delivery2.clear();
        this.delivery2.addAll(delivery2);
    }

    public OrderDeliveryData getData() {
        return new OrderDeliveryData()
                .setOrder1(order1)
                .setOrder2(order2)
                .setDelivery1(delivery1)
                .setDelivery2(delivery2);
    }


}
