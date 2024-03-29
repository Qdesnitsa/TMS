package by.tms.lesson13_generic_collection.shopping;

import by.tms.lesson13_generic_collection.entity.Article;
import by.tms.lesson13_generic_collection.input.InputData;
import by.tms.lesson13_generic_collection.output.Printer;
import by.tms.lesson13_generic_collection.shopping.action.ChoiceTypeTotal;
import by.tms.lesson13_generic_collection.shopping.action.show.TypesHandler;
import by.tms.lesson13_generic_collection.validation.ValidInput;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public final class Shop implements Serializable {

  private static final long serialVersionUID = -7055266736847453882L;
  private static Map<Integer, Article> map;
  //private static TreeSet<Article> sortedSet;
  private static Deque<Article> queue;
  private static List<Map.Entry<Integer, Article>> list;

  //private static Comparator priceComparator = new ArticlePriceComparator();

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

  public static List<Map.Entry<Integer, Article>> sortPriceAsc() {
    list = new ArrayList(map.entrySet());
    list.sort((Map.Entry<Integer, Article> art1, Map.Entry<Integer, Article> art2) -> art1.getValue().getPrice() - art2.getValue().getPrice());
    return list;
  }

  public static List<Map.Entry<Integer, Article>> sortPriceDesc() {
    list = new ArrayList(map.entrySet());
    list.sort((Map.Entry<Integer, Article> art1, Map.Entry<Integer, Article> art2) -> art2.getValue().getPrice() - art1.getValue().getPrice());
    return list;
  }

//  public static TreeSet<Article> sortPriceAsc() {
//    sortedSet = new TreeSet<>(priceComparator);
//    for (Entry<Integer, Article> articleIn : map.entrySet()) {
//      sortedSet.add(articleIn.getValue());
//    }
//    return sortedSet;
//  }
//
//  public static TreeSet<Article> sortPriceDesc() {
//    sortPriceAsc();
//    sortedSet = (TreeSet<Article>) sortedSet.descendingSet();
//    return sortedSet;
//  }

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

  //enum vs switch-case
  public static void actionAfterChoice() {
    int choice = Printer.showInstructions();
    ChoiceTypeTotal.getActionByType(choice).getAction().actionAfterChoice();
  }

  //map vs switch-case
  public static void actionAfterChoiceShow() {
    int choice = Printer.showNextInstructions();
    TypesHandler types = new TypesHandler();
    types.getType(choice).sortAfterShow();
  }
}



