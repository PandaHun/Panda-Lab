package com.pandahun.dddstart.shoppingmall.domain;

@FunctionalInterface
public interface ShippingChangeStrategy {

    boolean isShippingChangeable();
}
