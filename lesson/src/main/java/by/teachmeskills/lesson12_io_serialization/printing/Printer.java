package by.teachmeskills.lesson12_io_serialization.printing;

import java.util.List;

public final class Printer {
  private static final String HAS_BLACK_WORD = "Text contains words from black list. ";
  private static final String QUANTITY = "Quantity of sentences with black_list words equals: ";
  private static final String NO_BLACK_WORD = "Text does not contain words from black list";

  private Printer() {}

  public static void printSentBlackList(List<String> list) {
    int counter = 0;
    StringBuffer msgResultInfo = new StringBuffer();
    if (list.isEmpty()) {
      msgResultInfo.append(NO_BLACK_WORD);
    } else {
      msgResultInfo.append(HAS_BLACK_WORD).append(QUANTITY).append(list.size());
      for (String elem : list) {
        msgResultInfo.append("\n").append(++counter).append(". ").append(elem.trim());
      }
    }
    System.out.println(msgResultInfo);
  }

}
