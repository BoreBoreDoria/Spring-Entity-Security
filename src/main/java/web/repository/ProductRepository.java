package web.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  @EntityGraph(value = "product.categories")
  Page<Product> findByPriceGreaterThan(BigDecimal price, Pageable pageable);
  @EntityGraph(value = "product.categories", type = EntityGraph.EntityGraphType.FETCH)
  Optional<Product> findById(Long id);

  @EntityGraph(value = "product.categories")
  List<Product> findAllByPriceGreaterThan(BigDecimal price);
}
