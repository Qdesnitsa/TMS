package by.teachmeskills.lesson11_exception_serialization.main;

import by.teachmeskills.lesson11_exception_serialization.entity.Car;
import by.teachmeskills.lesson11_exception_serialization.exception.EvenNumberException;

public class Main {
  public static void main(String[] args) {
    try {
      new Car("BMW",250,100_000).start();
    } catch (EvenNumberException e) {
      System.out.println(e);
    }
  }
}
