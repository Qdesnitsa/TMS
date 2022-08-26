package by.teachmeskills.lesson13_generic_collection.comparator;

import by.teachmeskills.lesson13_generic_collection.entity.Article;
import java.util.Comparator;

public class ArticlePriceComparator implements Comparator<Article> {

  @Override
  public int compare(Article art1, Article art2) {
    if (art1.getPrice() > art2.getPrice()) {
      return 1;
    } else if (art1.getPrice() < art2.getPrice()) {
      return -1;
    } else {
      return 0;
    }
  }
}
