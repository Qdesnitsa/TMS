package by.tms.lesson13_generic_collection.comparator;

import by.tms.lesson13_generic_collection.entity.Article;
import java.util.Comparator;

public class ArticleNameComparator implements Comparator<Article> {

  @Override
  public int compare(Article art1, Article art2) {
    return art1.getName().compareTo(art2.getName());
  }
}