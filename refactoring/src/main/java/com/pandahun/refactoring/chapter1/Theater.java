package com.pandahun.refactoring.chapter1;

import static com.pandahun.refactoring.chapter1.PlayType.COMEDY;
import static com.pandahun.refactoring.chapter1.PlayType.TRAGEDY;

import java.util.Map;

public class Theater {

    private Map<String, Play> plays;

    public String statement(Invoice invoice, Map<String, Play> plays) {
        int totalAmount = 0;
        int volumeCredits = 0;
        this.plays = Map.copyOf(plays);
        String result = "청구 내역 (고객명: " + invoice.getCustomer() + ")\n";
        String format = "$%.2f";

        for (Performance perf : invoice.getPerformances()) {
            Play play = playFor(perf);
            int thisAmount = amountFor(perf);
            volumeCredits += Math.max(perf.getAudience() - 30, 0);
            if (play.getType() == COMEDY) {
                volumeCredits += Math.floor((double) perf.getAudience() / 5.0);
            }
            result += (play.getName() + ": " + String.format(format, (double) thisAmount / 100)
                + " "
                + perf.getAudience() + "석\n");
            totalAmount += thisAmount;
        }
        result += "총액: " + String.format(format, (double) totalAmount / 100) + "\n";
        result += "적립 포인트: " + volumeCredits + "점\n";
        return result;
    }

    private int amountFor(Performance performance) {
        int result;
        switch (playFor(performance).getType()) {
            case TRAGEDY:
                result = 40_000;
                if (performance.getAudience() > 30) {
                    result += 1000 * (performance.getAudience() - 30);
                }
                break;
            case COMEDY:
                result = 30_000;
                if (performance.getAudience() > 20) {
                    result += 10_000 + 500 * (performance.getAudience() - 20);
                }
                result += 300 * performance.getAudience();
                break;
            default:
                throw new IllegalArgumentException(
                    "알 수 없는 장르: " + playFor(performance)
                        .getType()
                        .getPlayType());
        }
        return result;
    }

    private Play playFor(Performance performance) {
        return plays.get(performance.getPlayId());
    }
}
