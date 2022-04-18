package by.teachmeskills.lesson12_io_serialization.formatting;

import java.util.ArrayList;
import java.util.List;

public final class TextFormatter {

  private static final String VALID_END_SENTENCE = "[.!?]\\s";

  private TextFormatter() {
  }

  public static boolean checkIsPalindrome(String str) {
    return (str.equals(new StringBuffer(str).reverse().toString()));
  }

  public static String[] obtainSentences(String text) {
    String[] sentences = text.split(VALID_END_SENTENCE);
    return sentences;
  }

  public static String[][] obtainWords(String[] str) {
    String[] words;
    String[][] wordsInSentence = new String[str.length][];
    for (int i = 0; i < str.length; i++) {
      words = str[i].split("\\s+");
      wordsInSentence[i] = new String[words.length];
      for (int j = 0; j < words.length; j++) {
        wordsInSentence[i][j] = words[j];
      }
    }
    return wordsInSentence;
  }

  public static boolean checkHasPalindrome(String[] words) {
    int minWordLength = 3;
    boolean find = false;
    for (String word : words) {
      if (checkIsPalindrome(word) && word.length() > minWordLength) {
        find = true;
      }
    }
    return find;
  }

  public static int countWords(String[] words) {
    return words.length;
  }

  public static List<String> checkFactors(String text) {
    int maxCountWords = 5;
    int minCountWords = 3;
    String[] sent = obtainSentences(text);
    String[][] word = obtainWords(sent);
    List<String> list = new ArrayList<>();
    for (int i = 0; i < word.length; i++) {
      if (TextFormatter.checkHasPalindrome(word[i]) ||
          (TextFormatter.countWords(word[i]) >= minCountWords && TextFormatter.countWords(word[i]) <= maxCountWords)) {
        list.add(sent[i]);
      }
    }
    return list;
  }
}

