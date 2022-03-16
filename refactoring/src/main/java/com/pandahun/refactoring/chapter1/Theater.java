package com.pandahun.refactoring.chapter1;

import static com.pandahun.refactoring.chapter1.PlayType.COMEDY;
import static com.pandahun.refactoring.chapter1.PlayType.TRAGEDY;

import java.util.Map;

public class Theater {

    public String statement(Invoice invoice, Map<String, Play> plays) {
        int totalAmount = 0;
        int volumeCredits = 0;
        String result = "û�� ���� (����: " + invoice.getCustomer() + ")\n";
        String format = "$%.2f";

        for (Performance perf : invoice.getPerformances()) {
            Play play = plays.get(perf.getPlayId());
            int thisAmount = amountFor(perf, play);
            volumeCredits += Math.max(perf.getAudience() - 30, 0);
            if (play.getType() == COMEDY) {
                volumeCredits += Math.floor((double) perf.getAudience() / 5.0);
            }
            result += (play.getName() + ": " + String.format(format, (double) thisAmount / 100)
                + " "
                + perf.getAudience() + "��\n");
            totalAmount += thisAmount;
        }
        result += "�Ѿ�: " + String.format(format, (double) totalAmount / 100) + "\n";
        result += "���� ����Ʈ: " + volumeCredits + "��\n";
        return result;
    }

    private int amountFor(Performance perf, Play play) {
        int thisAmount;
        switch (play.getType()) {
            case TRAGEDY:
                thisAmount = 40_000;
                if (perf.getAudience() > 30) {
                    thisAmount += 1000 * (perf.getAudience() - 30);
                }
                break;
            case COMEDY:
                thisAmount = 30_000;
                if (perf.getAudience() > 20) {
                    thisAmount += 10_000 + 500 * (perf.getAudience() - 20);
                }
                thisAmount += 300 * perf.getAudience();
                break;
            default:
                throw new IllegalArgumentException(
                    "�� �� ���� �帣: " + play.getType().getPlayType());
        }
        return thisAmount;
    }
}
