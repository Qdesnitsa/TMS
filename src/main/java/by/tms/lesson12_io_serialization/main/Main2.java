package by.tms.lesson12_io_serialization.main;

import by.tms.lesson12_io_serialization.formatting.TextFormatter;
import by.tms.lesson12_io_serialization.reading.Reading;
import by.tms.lesson12_io_serialization.writing.Writing;
import java.util.List;

public class Main2 {

  private static String inputFile2 = "./src/by/teachmeskills/lesson12_io_serialization/resource/input_2.txt";
  private static String outputFile2 = "./src/by/teachmeskills/lesson12_io_serialization/resource/output_2.txt";

  public static void main(String[] args) {

    String text = Reading.readTextFromFile(inputFile2);
    Writing.cleanFile(outputFile2);
    List<String> list = TextFormatter.checkFactorsPalindromeWordsInSent(text);
    Writing.writeToFile(outputFile2, list);
  }
}




