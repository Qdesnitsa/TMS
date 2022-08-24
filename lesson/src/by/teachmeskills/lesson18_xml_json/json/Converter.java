package by.teachmeskills.lesson18_xml_json.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Converter {

  private static final String baseFile = "src/by/teachmeskills/lesson18_xml_json/json/output_book.json";

  public static void toJSON(Book book) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File(baseFile),book);
    System.out.println("JSON created!");
  }

  public static Book toJavaObject() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    Book book = mapper.readValue(new File(baseFile),Book.class);
    System.out.println(book.toString());
    return book;
  }

}
