package by.teachmeskills.lesson13_browser;

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

  public void visit(String url) {
    ++currentPosition;
    list.add(currentPosition,url);
    //list.subList(0,currentPosition);
    for (int i = list.size() - 1; i > currentPosition; i--) {
      list.remove(i);
    }
  }

  public String back(int steps) {
    if (steps >= list.size()) {
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

  public static void main(String[] args) {
    BrowserHistory browserHistory = new BrowserHistory("1");
    browserHistory.visit("2");
    browserHistory.visit("3");
    browserHistory.visit("4");
    browserHistory.visit("5");
    browserHistory.back(2);
    browserHistory.visit("6");
    browserHistory.forward(1);
    browserHistory.visit("7");
    browserHistory.back(10);
    System.out.println(list);
    System.out.println(list.get(currentPosition));
  }

}
