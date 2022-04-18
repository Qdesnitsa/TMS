package by.teachmeskills.lesson12_io_serialization.reading;

import by.teachmeskills.lesson12_io_serialization.formatting.TextFormatter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class Reading {

  private static File file;
  private static FileReader fileReader;
  private static BufferedReader reader;

  private Reading() {
  }

  public static List<String> readLineFromFile(String filePath) {
    List<String> list = new ArrayList<>();
    try {
      file = new File(filePath);
      fileReader = new FileReader(file);
      reader = new BufferedReader(fileReader);
      String line;
      while (reader.ready()) {
        line = reader.readLine();
        if (TextFormatter.checkIsPalindrome(line)) {
          list.add(line);
        }
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException("File to read is not found", e);
    } catch (IOException ex) {
      throw new RuntimeException("Error while getting data from file", ex);
    } finally {
      try {
        reader.close();
      } catch (IOException exc) {
        throw new RuntimeException("Error in closing input file", exc);
      }
    }
    return list;
  }

  public static String readTextFromFile(String filePath) {
    try {
      return new String(Files.readAllBytes(Paths.get(filePath)));
    } catch (IOException e) {
      throw new RuntimeException("Error in reading text from file", e);
    }
  }
}
