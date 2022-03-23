package com.pandahun.dddstart.shoppingmall.domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(shippingAddress1, address.shippingAddress1)
            && Objects.equals(shippingAddress2, address.shippingAddress2)
            && Objects.equals(shippingZipCode, address.shippingZipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shippingAddress1, shippingAddress2, shippingZipCode);
    }
}
