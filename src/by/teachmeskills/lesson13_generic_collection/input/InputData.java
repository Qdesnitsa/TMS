package by.teachmeskills.lesson13_generic_collection.input;

import by.teachmeskills.lesson13_generic_collection.output.Printer;
import java.util.Scanner;

public final class InputData {

  private static String input;

  private InputData() {}

  public static String obtainInput() {
    Scanner scan = new Scanner(System.in);
    input = scan.nextLine();
    return input;
  }

  public static String obtainInputArticle(){
    Printer.printInstrForArticle();
    Scanner scan = new Scanner(System.in);
    input = scan.nextLine();
    return input;
  }
}
