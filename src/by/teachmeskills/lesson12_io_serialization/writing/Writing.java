package by.teachmeskills.lesson12_io_serialization.writing;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public final class Writing {
  private static final String EMPTY_LINE = "";

  private Writing() {}

  public static void writeToFile(String filePath, List<String> list) {
    int counter = 0;
    try (FileWriter fileWriter = new FileWriter(filePath, true)) {
      for (String element : list) {
        fileWriter.write(++counter + ". " + element.trim() + "\n");
      }
    } catch (IOException e) {
      throw new RuntimeException("Error in writing to file", e);
    }
  }

  public static void cleanFile(String filePath) {
    try (FileWriter fileWriter = new FileWriter(filePath, false)) {
      fileWriter.write(EMPTY_LINE);
    } catch (IOException e) {
      throw new RuntimeException("Error in cleaning file", e);
    }
  }
}
