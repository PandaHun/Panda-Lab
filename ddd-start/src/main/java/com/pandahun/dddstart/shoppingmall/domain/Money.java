package com.pandahun.dddstart.shoppingmall.domain;

import java.util.Objects;

public class Money {

    private int money;

    public Money(int money) {
        this.money = money;
    }

    public Money add(Money money) {
        return new Money(this.money + money.money);
    }

    public Money multiply(int multiplier) {
        return new Money(this.money * multiplier);
    }

    public int getMoney() {
        return money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}

