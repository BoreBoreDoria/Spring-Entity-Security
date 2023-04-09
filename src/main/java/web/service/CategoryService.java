package web.service;

import java.util.List;
import java.util.Optional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Category;
import web.repository.CategoryRepository;

@Service
@Transactional
public class CategoryService {

  private final CategoryRepository categoryRepository;


  @Autowired
  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public Category save(Category category) {
    return categoryRepository.save(category);
  }

  public Optional<Category> findById(Long id) {
    return categoryRepository.findById(id);
  }

  @Transactional
  public List<Category> findAll() {
    List<Category> all = categoryRepository.findAll();
    for (Category category : all) {
      Hibernate.initialize(category.getProducts());
    }
    return all;
  }

  public void delete(Category category) {
    categoryRepository.delete(category);
  }
}
