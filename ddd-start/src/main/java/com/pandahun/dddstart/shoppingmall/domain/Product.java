package com.pandahun.dddstart.shoppingmall.domain;

public class Product {

    private String name;
    private Money money;
    private String detail;

    public Product(String name, Money money, String detail) {
        this.name = name;
        this.money = money;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public Money getMoney() {
        return money;
    }

    public String getDetail() {
        return detail;
    }
}
