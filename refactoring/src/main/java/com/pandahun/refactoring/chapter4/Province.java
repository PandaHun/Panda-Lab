package com.pandahun.refactoring.chapter4;

import java.util.ArrayList;
import java.util.List;

public class Province {

    private final String name;
    private final List<Producer> producers;
    private int demand;
    private int price;
    private int totalProduction;

    public Province(ProvinceData data) {
        this.name = data.getName();
        this.totalProduction = 0;
        this.producers = new ArrayList<>();
        this.demand = data.getDemand();
        this.price = data.getPrice();
        data.getProducers().forEach(this::addProducer);
    }

    public String getName() {
        return name;
    }

    public List<Producer> getProducers() {
        return producers;
    }

    public int getDemand() {
        return demand;
    }

    public int getPrice() {
        return price;
    }

    public int getTotalProduction() {
        return totalProduction;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTotalProduction(int totalProduction) {
        this.totalProduction = totalProduction;
    }

    private void addProducer(Producer producer) {
        this.producers.add(producer);
        this.totalProduction += producer.getProduction();
    }
}
