package com.pandahun.refactoring.chapter1;

import static com.pandahun.refactoring.chapter1.PlayType.COMEDY;

import java.util.Map;

public class Theater {

    private Map<String, Play> plays;

    public String statement(Invoice invoice, Map<String, Play> plays) {
        int totalAmount = 0;
        this.plays = Map.copyOf(plays);
        String result = "û�� ���� (����: " + invoice.getCustomer() + ")\n";

        for (Performance perf : invoice.getPerformances()) {
            result += (playFor(perf).getName() + ": " + usd((double) amountFor(perf) / 100)
                + " "
                + perf.getAudience() + "��\n");
            totalAmount += amountFor(perf);
        }
        
        int volumeCredits = 0;
        for (Performance perf : invoice.getPerformances()) {
            volumeCredits += volumeCreditsFor(perf);
        }
        result += "�Ѿ�: " + usd((double) totalAmount / 100) + "\n";
        result += "���� ����Ʈ: " + volumeCredits + "��\n";
        return result;
    }

    private String usd(double number) {
        return String.format("$%.2f", number);
    }

    private int volumeCreditsFor(Performance perf) {
        int volumeCredits = 0;
        volumeCredits += Math.max(perf.getAudience() - 30, 0);
        if (playFor(perf).getType() == COMEDY) {
            volumeCredits += Math.floor((double) perf.getAudience() / 5.0);
        }
        return volumeCredits;
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
                    "�� �� ���� �帣: " + playFor(performance)
                        .getType()
                        .getPlayType());
        }
        return result;
    }

    private Play playFor(Performance performance) {
        return plays.get(performance.getPlayId());
    }
}
