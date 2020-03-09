package kitchenpos.products.tobe.domain;

import kitchenpos.products.tobe.domain.model.ProductPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ProductPriceTest {

    @DisplayName("상품의 가격이 null 이면 예외를 발생한다.")
    @ParameterizedTest
    @NullSource
    void create1(BigDecimal price) {
        // when, then
        assertThatThrownBy(() -> new ProductPrice(price))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품의 가격은 0원 이상이어야만 한다.");
    }

    @DisplayName("상품의 가격이 0원보다 작으면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(longs = {-1_000L, -2_000L, -3_000L})
    void create2(long price) {
        // when, then
        assertThatThrownBy(() -> new ProductPrice(BigDecimal.valueOf(price)))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품의 가격은 0원 이상이어야만 한다.");
    }

    @DisplayName("상품의 가격을 설정한다.")
    @Test
    void create3() {
        assertThatCode(() -> new ProductPrice(BigDecimal.valueOf(1_000L)))
                .doesNotThrowAnyException();
    }
}
