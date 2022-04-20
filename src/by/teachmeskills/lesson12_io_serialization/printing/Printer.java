package by.teachmeskills.lesson12_io_serialization.printing;

import java.util.List;

public class Printer {
  private static final String hasBlackWord = "Text contains words from black list. ";
  private static final String quantity = "Quantity of sentences with black_list words equals: ";
  private static final String noBlackWord = "Text does not contain words from black list";

  public static void printSentBlackList(List<String> list) {
    int counter = 0;
    StringBuffer stb = new StringBuffer();
    if (list.isEmpty()) {
      stb.append(noBlackWord);
    } else {
      stb.append(hasBlackWord).append(quantity).append(list.size());
      for (String elem : list) {
        stb.append("\n").append(++counter).append(". ").append(elem.trim());
      }
    }
    System.out.println(stb);
  }

}
