package by.tms.lesson11_exception_serialization.exception;

import by.tms.lesson11_exception_serialization.output.Printer;

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
