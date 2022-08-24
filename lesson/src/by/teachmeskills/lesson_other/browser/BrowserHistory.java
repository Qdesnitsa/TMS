package by.teachmeskills.lesson_other.browser;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {
  private String homepage;
  private static List<String> list;
  private static int currentPosition = 0;

  public BrowserHistory(String homepage) {
    this.homepage = homepage;
    list = new ArrayList<>();
    list.add(homepage);
  }

  public static List<String> getList() {
    return list;
  }

  public static int getCurrentPosition() {
    return currentPosition;
  }

  public void visit(String url) {
    list.add(++currentPosition,url);
    for (int i = list.size() - 1; i > currentPosition; i--) {
      list.remove(i);
    }
  }

  public String back(int steps) {
    if (steps >= currentPosition) {
      currentPosition = 0;
      return homepage;
    } else {
      currentPosition -= steps;
      return list.get(currentPosition);
    }
  }

  public String forward(int steps) {
    if ((steps + currentPosition) >= list.size()) {
      currentPosition = list.size() - 1;
      return list.get(currentPosition);
    } else {
      currentPosition += steps;
      return list.get(currentPosition);
    }
  }
}
