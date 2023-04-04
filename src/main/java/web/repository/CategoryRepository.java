package web.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import web.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
  @Query("SELECT DISTINCT a FROM Category a JOIN FETCH a.products")
  List<Category> listAll();
}
