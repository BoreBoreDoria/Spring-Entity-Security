package web.model;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.EntityGraph;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.Table;

@NamedEntityGraph(
    name = "product.categories",
    attributeNodes = {
        @NamedAttributeNode("name"),
        @NamedAttributeNode(value = "categories", subgraph = "categories.subcategories")
    },
    subgraphs = {
        @NamedSubgraph(
            name = "categories.subcategories",
            attributeNodes = {
                @NamedAttributeNode("name"),
                @NamedAttributeNode("subCategories")
            }
            )
    }
)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
@Data
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private BigDecimal price;

  @ManyToMany
  private List<Category> categories;

  public Product(String name, BigDecimal price) {
    this.name = name;
    this.price = price;
  }

  public Product(String name, BigDecimal price, List<Category> categories) {
    this.name = name;
    this.price = price;
    this.categories = categories;
  }
}
