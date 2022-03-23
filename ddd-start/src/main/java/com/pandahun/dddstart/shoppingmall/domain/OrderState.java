package com.pandahun.dddstart.shoppingmall.domain;

public enum OrderState {

    PAYMENT_WAITING(() -> true),
    PREPARING(() -> true),
    SHIPPED,
    DELIVERING,
    DELIVERY_COMPLETED,
    CANCELED;

    final ShippingChangeStrategy shippingChangeStrategy;

    OrderState(ShippingChangeStrategy shippingChangeStrategy) {
        this.shippingChangeStrategy = shippingChangeStrategy;
    }

    OrderState() {
        this.shippingChangeStrategy = () -> false;
    }

    public boolean isShippingChangeable() {
        return this.shippingChangeStrategy.isShippingChangeable();
    }
}
