package by.teachmeskills.lesson12_io_serialization.main;

import by.teachmeskills.lesson12_io_serialization.reading.Reading;
import by.teachmeskills.lesson12_io_serialization.writing.Writing;
import java.util.List;

public class Main1 {
  private static String inputFile1 = "./src/by/teachmeskills/lesson12_io_serialization/resource/input_1.txt";
  private static String outputFile1 = "./src/by/teachmeskills/lesson12_io_serialization/resource/output_1.txt";

  public static void main(String[] args) {
    List<String> list = Reading.readLineFromFileList(inputFile1);
    Writing.cleanFile(outputFile1);
    Writing.writeToFile(outputFile1,list);
  }
}
