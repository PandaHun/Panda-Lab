package com.pandahun.refactoring.chapter1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class TheaterTest {

    static Map<String, Play> plays = new HashMap<>();
    static Invoice invoice = new Invoice("BigCo", Arrays.asList(
        new Performance("hamlet", 55),
        new Performance("as-like", 35),
        new Performance("othello", 40)));

    static {
        plays.put("hamlet", new Play("hamlet", "Hamlet", PlayType.TRAGEDY));
        plays.put("as-like", new Play("as-like", "As You Like It", PlayType.COMEDY));
        plays.put("othello", new Play("othello", "Othello", PlayType.TRAGEDY));
    }


    @Test
    void 송장과_기록을_가지고_영수증을_출력할_수_있다() {
        Theater theater = new Theater();
        String result = theater.statement(invoice, plays);
        String expected = "청구 내역 (고객명: BigCo)\n"
            + "Hamlet: $650.00 55석\n"
            + "As You Like It: $580.00 35석\n"
            + "Othello: $500.00 40석\n"
            + "총액: $1730.00\n"
            + "적립 포인트: 47점\n";
        assertThat(result).isEqualTo(expected);
    }
}