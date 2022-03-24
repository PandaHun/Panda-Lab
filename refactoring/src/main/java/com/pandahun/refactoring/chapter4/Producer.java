package com.pandahun.refactoring.chapter4;

import java.util.Objects;

public class Producer {

    private final String name;
    private int cost;
    private int production;

    public Producer(String name, int cost, int production) {
        this.name = name;
        this.cost = cost;
        this.production = production;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getProduction() {
        return production;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setProduction(int production) {
        this.production = production;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Producer producer = (Producer) o;
        return Objects.equals(name, producer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
