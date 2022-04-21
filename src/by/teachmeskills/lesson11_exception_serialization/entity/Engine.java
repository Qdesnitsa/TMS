package by.teachmeskills.lesson11_exception_serialization.entity;

import static java.lang.Math.*;

import by.teachmeskills.lesson11_exception_serialization.exception.EvenNumberException;
import by.teachmeskills.lesson11_exception_serialization.output.Printer;
import java.io.Serializable;

public final class Engine implements Serializable {

  private static final long serialVersionUID = -5953176735361137008L;
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
