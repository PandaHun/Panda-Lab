package com.pandahun.dddstart.shoppingmall.domain;

import java.util.List;
import java.util.Objects;

public class Order {

    private String orderNumber;
    private List<OrderLine> orderLines;
    private int totalAmounts;
    private OrderState state;
    private ShippingInfo shippingInfo;

    public Order(String orderNumber, List<OrderLine> orderLines, OrderState state,
        ShippingInfo shippingInfo) {
        this.orderNumber = orderNumber;
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
        this.state = state;
    }

    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        verifyNotYetShipped();
        setShippingInfo(newShippingInfo);
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) {
            throw new IllegalArgumentException("no ShippingInfo");
        }
        this.shippingInfo = shippingInfo;
    }

    public void cancelOrder() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmount();
    }

    private void calculateTotalAmount() {
        this.totalAmounts = orderLines.stream()
            .mapToInt(OrderLine::getAmounts)
            .sum();
    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no OrderLines");
        }
    }

    private void verifyNotYetShipped() {
        if (!state.isShippingChangeable()) {
            throw new IllegalStateException("already shipped");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return orderNumber.equals(order.orderNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber);
    }
}
