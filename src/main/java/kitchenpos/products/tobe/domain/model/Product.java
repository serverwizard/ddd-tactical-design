package kitchenpos.products.tobe.domain.model;

import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Embedded
    private ProductPrice price;

    public Product() {
    }

    public Product(String name, BigDecimal price) {
        validateNameNotNull(name);

        this.name = name;
        this.price = new ProductPrice(price);
    }

    private void validateNameNotNull(String name) {
        if (Strings.isBlank(name)) {
            throw new IllegalArgumentException("상품은 이름을 가져야만 한다.");
        }
    }
}
