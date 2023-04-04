package web.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import web.model.Category;
import web.model.Product;
import web.service.CategoryService;
import web.service.ProductService;

@Component
@RequiredArgsConstructor
public class ProductCreateService {
  private final CategoryService categoryService;
  private final ProductService productService;
  private final String[] themes = {"Книги", "Электроника", "Одежда", "Косметика", "Игрушки", "Спортивные товары"};
  private ArrayList<Category> categories = new ArrayList<>();

  private final String[][] products = {
      {"Война и мир", "Преступление и наказание", "Анна Каренина"},
      {"Смартфон Samsung", "Ноутбук HP", "Планшет Apple iPad"},
      {"Футболка Levi's", "Джинсы Wrangler", "Куртка Columbia"},
      {"Тональный крем L'Oreal", "Губная помада Maybelline", "Тени для век MAC"},
      {"Конструктор LEGO", "Мягкая игрушка Teddy Bear", "Настольная игра Monopoly"},
      {"Беговая дорожка NordicTrack", "Велосипед Merida", "Боксерские перчатки Everlast"}
  };

  public Product getRandomProductAndTheme() {
    Random random = new Random();
    int themeIndex = random.nextInt(themes.length);
    int productIndex = random.nextInt(products[themeIndex].length);
    Category category = categories.get(themeIndex);
    String product = products[themeIndex][productIndex];
    return productService.save(new Product(product, BigDecimal.valueOf(random.nextInt(500)), category));
  }

  public void saveThemes() {
    for (String theme : themes) {
      Category category = new Category(theme);
      category = categoryService.save(category);
      categories.add(category);
      System.out.println("Создана категория:" + category);
    }
  }
}
