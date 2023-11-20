package by.tms.lesson13_generic_collection.main;

import by.tms.lesson13_generic_collection.entity.Article;
import by.tms.lesson13_generic_collection.shopping.Shop;

public class Main {

  public static void main(String[] args) {
    Shop shop = new Shop();
    Shop.addArticle(new Article(10,"Book",120));
    Shop.addArticle(new Article(1,"Pencil",12));
    Shop.addArticle(new Article(7,"Paper",1_000_000));
    Shop.addArticle(new Article(10,"WorkBook",97));
    Shop.addArticle(new Article(100,"Scissors",55));
    Shop.actionAfterChoice();
  }

}
