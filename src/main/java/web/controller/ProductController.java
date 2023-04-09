package web.controller;

import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Category;
import web.model.Product;
import web.model.User;
import web.repository.ProductCreateService;
import web.service.CategoryService;
import web.service.ProductService;
import web.service.UserServiceEntity;

@Controller
@RequestMapping(value = "/product")
@RequiredArgsConstructor
public class ProductController {

  private final ProductCreateService productCreateService;
  private final ProductService productService;
  private final CategoryService categoryService;

  @GetMapping(value = "/createCategory")
  public ResponseEntity<Void> createCategory() {
    productCreateService.saveThemes();
    return ResponseEntity.ok().build();
  }

  @GetMapping(value = "/createProduct")
  public ResponseEntity<String> createProduct() {
    Product randomProductAndTheme = productCreateService.getRandomProductAndTheme();
    return ResponseEntity.ok(randomProductAndTheme.toString());
  }

  @GetMapping(value = "/findProductByPrice")
  public ResponseEntity<String> findProductByPrice(@RequestParam BigDecimal price) {
    Pageable pageable = PageRequest.of(0,4, Sort.by("price").ascending());
    Page<Product> result = productService.findByPrice(price, pageable);
    System.out.println(result.getNumber());
    System.out.println(result.getTotalElements());
    System.out.println(result.getSize());
    System.out.println(result.getTotalPages());
    return ResponseEntity.ok(result.toString());
  }

  @GetMapping(value = "/findAllProducts")
  public ResponseEntity<String> findAllCategories() {
    List<Category> all = categoryService.findAll();
    for (Category category : all) {
      for (Product product : category.getProducts()) {
        System.out.println(product);
      }
    }
    return ResponseEntity.ok(all.toString());
  }

  @GetMapping(value = "/getProduct/{id}")
  public ResponseEntity<String> getProductByID(@PathVariable Long id) {
    Product product = productService.findByIdWithSubCategory(id);
    return ResponseEntity.ok(product.toString());
  }
}