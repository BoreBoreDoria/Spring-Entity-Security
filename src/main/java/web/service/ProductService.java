package web.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Product;
import web.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
  private final ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product save(Product product) {
    return productRepository.save(product);
  }

  public Optional<Product> findById(Long id) {
    return productRepository.findById(id);
  }

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public void delete(Product product) {
    productRepository.delete(product);
  }


  public Page<Product> findByPrice(BigDecimal price, Pageable pageable) {
    return productRepository.findByPriceGreaterThan(price, pageable);
  }

  public Product findByIdWithSubCategory(Long id) {
    return productRepository.findById(id).get();
  }
}
