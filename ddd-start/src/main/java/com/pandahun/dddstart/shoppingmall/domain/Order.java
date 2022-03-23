package com.pandahun.dddstart.shoppingmall.domain;

import java.util.List;

public class Order {

    private List<OrderLine> orderLines;
    private int totalAmounts;
    private ShippingInfo shippingInfo;

    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo) {
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }

    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        setShippingInfo(newShippingInfo);
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) {
            throw new IllegalArgumentException("no ShippingInfo");
        }
        this.shippingInfo = shippingInfo;
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
}
