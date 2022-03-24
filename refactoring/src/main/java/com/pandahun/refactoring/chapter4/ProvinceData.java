package com.pandahun.refactoring.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProvinceData {

    private final String name;
    private final List<Producer> producers;
    private final int demand;
    private final int price;

    private ProvinceData(String name,
        List<Producer> producers, int demand, int price) {
        this.name = name;
        this.producers = producers;
        this.demand = demand;
        this.price = price;
    }

    public static ProvinceData sampleData() {
        return new ProvinceData("Asia",
            Arrays.asList(new Producer("Byzantium", 10, 9),
                new Producer("Attalia", 12, 10),
                new Producer("Sinope", 10, 6)), 30, 20);
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
}
