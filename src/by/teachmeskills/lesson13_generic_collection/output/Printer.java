package by.teachmeskills.lesson13_generic_collection.output;

import by.teachmeskills.lesson13_generic_collection.entity.Article;
import by.teachmeskills.lesson13_generic_collection.validation.ValidInput;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public final class Printer {
  private static final String NO_ELEM_MSG = "List of articles is empty";
  private static final String INITIAL_MSG = "Choose operation: ";
  private static final String INVALID_VALUE = "Invalid input. Try again.";

  private Printer() {
  }

  public static void printInvalidInput() {
    System.out.println(INVALID_VALUE);
  }

  public static void printElementsMap(Map<Integer, Article> map) {
    if (!map.isEmpty()) {
      for (Entry<Integer, Article> article : map.entrySet()) {
        System.out.println(article);
      }
    } else{
      System.out.println(NO_ELEM_MSG);
    }
  }

  public static void printElementsSet(TreeSet<Article> set) {
    for (Article article : set) {
      System.out.println(article);
    }
  }

  public static void printElementsQueue(Queue<Article> queue) {
    for (Article article : queue) {
      System.out.println(article);
    }
  }

  private static final String ARTICLE_INFO = "Enter Article info (3 parameters) divided by spaces: id(integer) name(text) price(integer):";
  public static void printInstrForArticle() {
    System.out.println(ARTICLE_INFO);
  }

  private static final String ARTICLE_DELETE_INFO = "Enter Article id(integer) to remove: ";
  public static void printInstrToDelete() {
    System.out.println(ARTICLE_DELETE_INFO);
  }

  private static final String ZERO_OPTION = "Operations available:\n";
  private static final String FIRST_OPTION = "1. Show all articles\n";
  private static final String SECOND_OPTION = "2. Add article(s)\n";
  private static final String THIRD_OPTION = "3. Delete article(s)\n";
  private static final String FOURTH_OPTION = "4. Change parameter(s) of existing article(s)\n";
  private static final String FIFTH_OPTION = "5. Exit\n";
  private static final int MAX_NUMBER_OF_OPER = 5;
  private static final int MIN_NUMBER_OF_OPER = 1;
  public static int showInstructions(){
    String choice;
    int choiceInt;
    Scanner scan = new Scanner(System.in);
    StringBuilder instrForUser = new StringBuilder();
    instrForUser.append(ZERO_OPTION)
        .append(FIRST_OPTION)
        .append(SECOND_OPTION)
        .append(THIRD_OPTION)
        .append(FOURTH_OPTION)
        .append(FIFTH_OPTION)
        .append(INITIAL_MSG);
    do {
      System.out.println(instrForUser);
      choice = scan.nextLine();
      choiceInt = ValidInput.checkOverflowInt(choice);
    } while (choiceInt < MIN_NUMBER_OF_OPER || choiceInt > MAX_NUMBER_OF_OPER);
    return choiceInt;
  }

  private static final String SORT_PRICE_ASC = "1. Sort articles by price in ascending order\n";
  private static final String SORT_PRICE_DESC = "2. Sort articles by price in descending order\n";
  private static final String SORT_NEW_FIRST = "3. Show new articles first\n";
  private static final int MAX_NUMBER_OF_OPER2 = 3;
  private static final int MIN_NUMBER_OF_OPER2 = 1;
  public static int showNextInstructions() {
    String choice;
    int choiceInt;
    Scanner scan = new Scanner(System.in);
    StringBuilder instrForUser2 = new StringBuilder();
    instrForUser2.append(SORT_PRICE_ASC)
        .append(SORT_PRICE_DESC)
        .append(SORT_NEW_FIRST);
    do {
      System.out.println(instrForUser2);
      choice = scan.nextLine();
      choiceInt = ValidInput.checkOverflowInt(choice);
    } while (choiceInt < MIN_NUMBER_OF_OPER2 || choiceInt > MAX_NUMBER_OF_OPER2);
    return choiceInt;
  }
}

