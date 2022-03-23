package com.pandahun.dddstart.shoppingmall.domain;

public class Money {

    private int money;

    public Money(int money) {
        this.money = money;
    }

    public Money add(Money money) {
        return new Money(this.money + money.money);
    }

    public int getMoney() {
        return money;
    }
}

