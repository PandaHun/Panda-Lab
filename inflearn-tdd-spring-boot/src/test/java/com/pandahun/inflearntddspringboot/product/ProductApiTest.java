package com.pandahun.inflearntddspringboot.product;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.pandahun.inflearntddspringboot.ApiTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductApiTest extends ApiTest {

    @Autowired
    private ProductService productService;

    @Test
    void 상품등록() {
        final var request = 상품등록요청_생성();

        RestAssured.given().log().all()
            .contentType(APPLICATION_JSON_VALUE)
            .body(request)
            .when()
            .post("/products")
            .then()
            .log().all().extract();
    }

    private AddProductRequest 상품등록요청_생성() {
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        return new AddProductRequest(name, price, discountPolicy);
    }
}
