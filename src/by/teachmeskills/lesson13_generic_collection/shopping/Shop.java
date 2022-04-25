package by.teachmeskills.lesson13_generic_collection.shopping;

import by.teachmeskills.lesson13_generic_collection.comparator.ArticlePriceComparator;
import by.teachmeskills.lesson13_generic_collection.entity.Article;
import by.teachmeskills.lesson13_generic_collection.input.InputData;
import by.teachmeskills.lesson13_generic_collection.output.Printer;
import by.teachmeskills.lesson13_generic_collection.validation.ValidInput;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeSet;

public final class Shop implements Serializable {

  private static final long serialVersionUID = -7055266736847453882L;
  private static Map<Integer, Article> map;
  private static TreeSet<Article> sortedSet;
  private static Deque<Article> queue;

  private static Comparator priceComparator = new ArticlePriceComparator();

  public Shop() {
    map = new LinkedHashMap<>();
  }

  public static boolean checkIdExists(Article article) {
    return map.containsKey(article.getId());
  }

  public static Map<Integer, Article> addArticle(Article article) {
    if (!checkIdExists(article) && article != null) {
      map.put(article.getId(), article);
    }
    return map;
  }

  public static Map<Integer, Article> deleteArticle(int id) {
    map.remove(id);
    return map;
  }

  public static Map<Integer, Article> modifyArticle(Article article) {
    for (Entry<Integer, Article> articleIn : map.entrySet()) {
      if (article.getId() == articleIn.getKey()) {
        articleIn.getValue().setId(article.getId());
        articleIn.getValue().setName(article.getName());
        articleIn.getValue().setPrice(article.getPrice());
      }
    }
    return map;
  }

  public static TreeSet<Article> sortPriceAsc() {
    sortedSet = new TreeSet<Article>(priceComparator);
    for (Entry<Integer, Article> articleIn : map.entrySet()) {
      sortedSet.add(articleIn.getValue());
    }
    return sortedSet;
  }

  public static TreeSet<Article> sortPriceDesc() {
    sortPriceAsc();
    sortedSet = (TreeSet<Article>) sortedSet.descendingSet();
    return sortedSet;
  }

  public static Queue<Article> sortAddDesc() {
    queue = new ArrayDeque<>();
    for (Entry<Integer, Article> articleIn : map.entrySet()) {
      queue.push(articleIn.getValue());
    }
    return queue;
  }

  private static String PARAM_DELIMETER = " ";
  public static Article obtainParamOfArticle(String parameters) {
    int paramNumber = 3;
    String[] param = parameters.split(PARAM_DELIMETER);
    while (!(param.length == paramNumber)) {
      Printer.printInstrForArticle();
      parameters = InputData.obtainInput();
      param = parameters.split(PARAM_DELIMETER);
    }
    int id = ValidInput.checkOverflowInt(param[0]);
    String name = param[1];
    int price = ValidInput.checkOverflowInt(param[2]);
    return new Article(id, name, price);
  }

  public static void actionAfterChoice() {
    int choice = Printer.showInstructions();
    switch (choice) {
      case 1:
        actionAfterChoice2();
        actionAfterChoice();
        break;
      case 2:
        Printer.printInstrForArticle();
        Printer.printElementsMap(addArticle(obtainParamOfArticle(InputData.obtainInput())));
        actionAfterChoice();
        break;
      case 3:
        Printer.printInstrToDelete();
        Printer.printElementsMap(deleteArticle(ValidInput.checkOverflowInt(InputData.obtainInput())));
        actionAfterChoice();
        break;
      case 4:
        Printer.printInstrForArticle();
        Printer.printElementsMap(modifyArticle(obtainParamOfArticle(InputData.obtainInput())));
        actionAfterChoice();
      case 5:
        break;
    }
  }

  public static void actionAfterChoice2() {
    int choice = Printer.showNextInstructions();
    switch (choice) {
      case 1:
        Printer.printElementsSet(sortPriceAsc());
        break;
      case 2:
        Printer.printElementsSet(sortPriceDesc());
        break;
      case 3:
        Printer.printElementsQueue(sortAddDesc());
        break;
    }
  }
}



