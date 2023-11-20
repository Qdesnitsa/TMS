package by.tms.lesson18_xml_json.json;

import java.io.IOException;

public class MainJSON {

  public static void main(String[] args) throws IOException {
    Book book = new Book(1,"The Little Prince",1943,"Novella","Antoine de Saint-Exupery");

    Converter.toJSON(book);
    Converter.toJavaObject();
  }

}
