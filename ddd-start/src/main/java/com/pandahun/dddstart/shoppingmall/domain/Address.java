package com.pandahun.dddstart.shoppingmall.domain;

public class Address {

    private String shippingAddress1;
    private String shippingAddress2;
    private String shippingZipCode;

    public Address(String shippingAddress1, String shippingAddress2, String shippingZipCode) {
        this.shippingAddress1 = shippingAddress1;
        this.shippingAddress2 = shippingAddress2;
        this.shippingZipCode = shippingZipCode;
    }

    public String getShippingAddress1() {
        return shippingAddress1;
    }
}
