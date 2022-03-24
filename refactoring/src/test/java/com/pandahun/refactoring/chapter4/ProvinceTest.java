package com.pandahun.refactoring.chapter4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProvinceTest {

    @DisplayName("부족 분 테스트")
    @Test
    void shortFallTest() {
        Province asia = new Province(ProvinceData.sampleData());
        assertThat(asia.getShortFall()).isEqualTo(5);
    }

    @DisplayName("부족분 실패 테스트")
    @Test
    void shortFallErrorTest() {
        Province asia = new Province(ProvinceData.sampleData());
        assertThat(asia.getShortFall()).isNotEqualTo(6);
    }
}