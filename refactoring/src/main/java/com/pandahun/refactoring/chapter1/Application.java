package com.pandahun.refactoring.chapter1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        Map<String, Play> plays = new HashMap<>();
        plays.put("hamlet", new Play("hamlet", "Hamlet", PlayType.TRAGEDY));
        plays.put("as-like", new Play("as-like", "As You Like It", PlayType.COMEDY));
        plays.put("othello", new Play("othello", "Othello", PlayType.TRAGEDY));

        Performance[] performances = {new Performance("hamlet", 55), new Performance("as-like", 35),
            new Performance("othello", 40)};
        Invoice invoice = new Invoice("BigCo", Arrays.asList(performances));

        Theater theater = new Theater();
        String result = theater.statement(invoice, plays);
        System.out.println(result);
    }

}
