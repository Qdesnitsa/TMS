package by.teachmeskills.lesson11_exception.exception;

import by.teachmeskills.lesson11_exception.output.Printer;

public class EvenNumberException extends Exception{
  private int number;

  public EvenNumberException (int number) {
    this.number = number;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() +
        " reason: " + Printer.printBadMsg(number);
  }
}
