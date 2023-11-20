package by.tms.lesson13_generic_collection.input;

import java.util.Scanner;

public final class InputData {

  private static String input;

  private InputData() {}

  public static String obtainInput() {
    Scanner scan = new Scanner(System.in);
    input = scan.nextLine();
    return input;
  }

}
