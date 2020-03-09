package kitchenpos.products.tobe.domain.repository;

import kitchenpos.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
