package by.teachmeskills.lesson13_generic_collection.main;

import static by.teachmeskills.lesson13_generic_collection.shopping.Shop.*;
import by.teachmeskills.lesson13_generic_collection.entity.Article;
import by.teachmeskills.lesson13_generic_collection.shopping.Shop;
import java.lang.reflect.InvocationTargetException;

public class Main {

  public static void main(String[] args)
      throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    Shop shop = new Shop();
    addArticle(new Article(10,"Book",120));
    addArticle(new Article(1,"Pencil",12));
    addArticle(new Article(7,"Paper",1_000_000));
    addArticle(new Article(10,"WorkBook",97));
    addArticle(new Article(100,"Scissors",55));
    Shop.actionAfterChoice();
  }

}
