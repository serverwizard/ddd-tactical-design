package kitchenpos.products.tobe.domain;

import kitchenpos.products.tobe.domain.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ProductTest {

    @DisplayName("상품을 등록할 때, 상품 이름이 없으면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void create1(String name) {
        // when, then
        assertThatThrownBy(() -> Product.from(name, BigDecimal.valueOf(1_000)))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품은 이름을 가져야만 한다.");
    }

    @DisplayName("상품을 등록한다.")
    @Test
    void create2() {
        // when, then
        assertThatCode(() -> Product.from("양념치킨", BigDecimal.valueOf(1_000L)))
                .doesNotThrowAnyException();
    }
}
