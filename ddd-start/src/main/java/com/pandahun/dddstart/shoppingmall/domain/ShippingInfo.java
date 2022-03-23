package com.pandahun.dddstart.shoppingmall.domain;

public class ShippingInfo {

    private Receiver receiver;
    private String shippingAddress1;
    private String shippingAddress2;
    private String shippingZipCode;

    public ShippingInfo(Receiver receiver, String shippingAddress1, String shippingAddress2,
        String shippingZipCode) {
        this.receiver = receiver;
        this.shippingAddress1 = shippingAddress1;
        this.shippingAddress2 = shippingAddress2;
        this.shippingZipCode = shippingZipCode;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public String getShippingAddress1() {
        return shippingAddress1;
    }

    public String getShippingAddress2() {
        return shippingAddress2;
    }

    public String getShippingZipCode() {
        return shippingZipCode;
    }
}
