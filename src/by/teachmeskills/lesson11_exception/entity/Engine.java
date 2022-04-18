package by.teachmeskills.lesson11_exception.entity;

import static java.lang.Math.*;

import by.teachmeskills.lesson11_exception.exception.EvenNumberException;
import by.teachmeskills.lesson11_exception.output.Printer;

public final class Engine {
  private int indicator;

  public int getIndicator() {
    return indicator;
  }

  public int obtainRandomInt() {
    return this.indicator = (int) (random() * 20);
  }

  public boolean checkRandomIsEven() {
    return obtainRandomInt() % 2 == 0;
  }

  public void obtainResult() throws EvenNumberException{
    if (checkRandomIsEven()) {
      throw new EvenNumberException(indicator);
    } else {
      Printer.printGoodMsg(indicator);
    }
  }
}
