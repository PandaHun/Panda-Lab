package com.pandahun.dddstart.shoppingmall.domain;

public class OrderLine {

    private Product product;
    private Money price;
    private int quantity;
    private Money amounts;


    public OrderLine(Product product, Money price, int quantity) {
        this.product = product;
        this.price = new Money(price.getMoney());
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    private Money calculateAmounts() {
        return price.multiply(quantity);
    }

    public Product getProduct() {
        return product;
    }

    public int getPrice() {
        return price.getMoney();
    }

    public int getQuantity() {
        return quantity;
    }

    public int getAmounts() {
        return amounts.getMoney();
    }
}
