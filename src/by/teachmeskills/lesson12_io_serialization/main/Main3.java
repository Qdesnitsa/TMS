package by.teachmeskills.lesson12_io_serialization.main;

import by.teachmeskills.lesson12_io_serialization.formatting.TextFormatter;
import by.teachmeskills.lesson12_io_serialization.printing.Printer;
import by.teachmeskills.lesson12_io_serialization.reading.Reading;
import by.teachmeskills.lesson12_io_serialization.writing.Writing;
import java.util.List;

public class Main3 {
  private static String inputFile2 = "./src/by/teachmeskills/lesson12_io_serialization/resource/input_2.txt";
  private static String inputFile3 = "./src/by/teachmeskills/lesson12_io_serialization/resource/black_list_3.txt";
  private static String outputFile3 = "./src/by/teachmeskills/lesson12_io_serialization/resource/output_3.txt";

  public static void main(String[] args) {
    String text1 = Reading.readTextFromFile(inputFile2);
    String[] str1 = TextFormatter.obtainSentences(text1);
    String text2 = Reading.readTextFromFile(inputFile3);
    String[] str2 = TextFormatter.obtainLines(text2);
    List<String> list = TextFormatter.checkHasWords(str1,str2);
    Printer.printSentBlackList(list);
    Writing.cleanFile(outputFile3);
    Writing.writeToFile(outputFile3, list);
  }
}
