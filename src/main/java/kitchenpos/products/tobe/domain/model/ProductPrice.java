package kitchenpos.products.tobe.domain.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Objects;

@Access(AccessType.FIELD)
@Embeddable
public class ProductPrice {
    @Column(nullable = false)
    private BigDecimal price;

    protected ProductPrice() {
    }

    public ProductPrice(BigDecimal price) {
        validatePriceNotNullAndGreaterThanZero(price);
        this.price = price;
    }

    private void validatePriceNotNullAndGreaterThanZero(BigDecimal price) {
        if (Objects.isNull(price) || BigDecimal.ZERO.compareTo(price) > 0) {
            throw new IllegalArgumentException("상품의 가격은 0원 이상이어야만 한다.");
        }
    }

}
