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


  public static void main(String[] args) {
    BrowserHistory browserHistory = new BrowserHistory("fmbte.com");//
    browserHistory.visit("gtbcpfz.com");
    browserHistory.visit("lkw.com");
    browserHistory.visit("fosekfi.com");

    browserHistory.back(3);
    browserHistory.forward(2);

    browserHistory.visit("wtub.com");
    browserHistory.visit("cymzd.com");
    browserHistory.visit("pnep.com");
    browserHistory.visit("cwqnss.com");

    browserHistory.back(5);
    browserHistory.forward(4);

    browserHistory.visit("gzhsy.com");

    browserHistory.forward(8);

    browserHistory.visit("tiuj.com");
    browserHistory.visit("zkl.com");
    browserHistory.visit("ypei.com");
    browserHistory.visit("uctrp.com");

    browserHistory.forward(5);
    browserHistory.back(3);

    browserHistory.visit("wo.com");

    browserHistory.back(7);

    browserHistory.visit("rwqe.com");
    browserHistory.visit("rilu.com");

    browserHistory.back(10);
    browserHistory.forward(1);
    browserHistory.forward(7);

    browserHistory.visit("uaz.com");
    browserHistory.visit("em.com");

    browserHistory.forward(4);

    browserHistory.visit("qci.com");
    browserHistory.visit("clsk.com");
    browserHistory.visit("mebuat.com");
    browserHistory.visit("vozvxqc.com");
    browserHistory.visit("ejiheyj.com");

    browserHistory.back(8);

    browserHistory.visit("bvkvzr.com");
    browserHistory.visit("zlfrqt.com");

    browserHistory.back(4);
    browserHistory.back(2);
    browserHistory.forward(3);
    browserHistory.back(6);

    browserHistory.visit("xnzy.com");
    
    browserHistory.back(9);

    System.out.println(list);
    System.out.println(list.get(currentPosition));
  }

}
