package com.pandahun.refactoring.chapter4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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

    public int getShortFall() {
        return demand - totalProduction;
    }

    public int getProfit() {
        return demandValue() - demandCost();
    }

    private int demandCost() {
        AtomicInteger remainingDemand = new AtomicInteger(demand);
        AtomicInteger result = new AtomicInteger();
        producers.stream()
            .sorted(Comparator.comparingInt(Producer::getCost))
            .forEach(producer -> {
                int contribution = Math.min(remainingDemand.get(), producer.getProduction());
                remainingDemand.addAndGet(-contribution);
                result.addAndGet(contribution * producer.getCost());
            });
        return result.get();
    }

    private int demandValue() {
        return satisfiedDemand() * price;
    }

    private int satisfiedDemand() {
        return Math.min(demand, totalProduction);
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
