package com.pandahun.dddstart.shoppingmall.domain;

public class Order {

    private ShippingInfo shippingInfo;

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) {
            throw new IllegalArgumentException("no ShippingInfo");
        }
        this.shippingInfo = shippingInfo;
    }
}
