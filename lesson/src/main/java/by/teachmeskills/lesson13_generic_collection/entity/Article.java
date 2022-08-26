package by.teachmeskills.lesson13_generic_collection.entity;

import java.io.Serializable;
import java.util.Objects;

public final class Article implements Serializable {

  private static final long serialVersionUID = -1690447909860163236L;
  private int id;
  private String name;
  private int price;

  public Article(int id, String name, int price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Article article = (Article) o;
    return id == article.id && price == article.price && Objects.equals(name, article.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, price);
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() +
        ", id=" + id +
        ", name='" + name + '\'' +
        ", price=" + price;
  }

}
