package com.pandahun.inflearntddspringboot.product;

import org.springframework.util.Assert;

record AddProductRequest(String name, int price, DiscountPolicy discountPolicy) {

    AddProductRequest {
        Assert.hasText(name, "��ǰ���� �ʼ��Դϴ�.");
        Assert.isTrue(price > 0, "��ǰ ������ 0���� Ŀ�� �մϴ�.");
        Assert.notNull(discountPolicy, "���� ��å�� �ʼ��Դϴ�.");
    }

}
