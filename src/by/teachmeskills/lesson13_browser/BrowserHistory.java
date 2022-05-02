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
    BrowserHistory bh = new BrowserHistory("1");
    bh.visit("2");
    bh.visit("3");
    bh.visit("4");
    bh.visit("5");
    bh.back(2);
    bh.visit("6");
    bh.forward(1);
    bh.visit("7");
    bh.back(10);
    System.out.println(list);
    System.out.println(list.get(currentPosition));
  }

}
