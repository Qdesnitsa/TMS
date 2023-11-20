package by.tms.lesson12_io_serialization.formatting;

import java.util.ArrayList;
import java.util.List;

public final class TextFormatter {

  private TextFormatter() {
  }

  private static final String SIGNS_TO_REPLACE = "[!?.,:;]";
  private static final String EMPTY_REPLACEMENT_SYMBOL = "";
  public static boolean checkIsPalindrome(String str) {
    String word = str.replaceAll(SIGNS_TO_REPLACE,EMPTY_REPLACEMENT_SYMBOL);
    return (word.equals(new StringBuffer(word).reverse().toString()));
  }

  private static final String VALID_END_SENTENCE = "[.!?]";
  public static String[] obtainSentences(String text) {
    String[] sentences = text.split(VALID_END_SENTENCE);
    return sentences;
  }

  private static final String VALID_END_LINE = "[\\t\\v\\f\\r\\n]+";
  public static String[] obtainLines(String text) {
    String[] lines = text.split(VALID_END_LINE);
    return lines;
  }

  private static final String SPACE_SYMBOL = "\\s+";
  public static String[][] obtainWordsInSentences(String[] str) {
    String[] sentences;
    String[][] wordsInSentence = new String[str.length][];
    for (int i = 0; i < str.length; i++) {
      sentences = str[i].split(SPACE_SYMBOL);
      wordsInSentence[i] = new String[sentences.length];
      for (int j = 0; j < sentences.length; j++) {
        wordsInSentence[i][j] = sentences[j];
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

  public static List<String> checkFactorsPalindromeWordsInSent(String text) {
    int maxCountWords = 5;
    int minCountWords = 3;
    String[] sent = obtainSentences(text);
    String[][] word = obtainWordsInSentences(sent);
    List<String> list = new ArrayList<>();
    for (int i = 0; i < word.length; i++) {
      if (checkHasPalindrome(word[i]) ||
          (countWords(word[i]) >= minCountWords && countWords(word[i]) <= maxCountWords)) {
        list.add(sent[i]);
      }
    }
    return list;
  }

  public static List<String> checkSentHasWords(String[] sentences, String[] words) {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < sentences.length; i++) {
      for (int j = 0; j < words.length; j++) {
        if (sentences[i].contains(words[j])) {
          list.add(sentences[i]);
        }
      }
    }
    return list;
  }
}

