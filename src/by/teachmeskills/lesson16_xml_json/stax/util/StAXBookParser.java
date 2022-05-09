package by.teachmeskills.lesson16_xml_json.stax.util;

import by.teachmeskills.lesson16_xml_json.stax.entity.Book;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAXBookParser {
  public static XMLStreamReader parse() throws FileNotFoundException {
    XMLStreamReader reader = null;
    XMLInputFactory inputFactory = XMLInputFactory.newInstance();
    try {
      InputStream input = new FileInputStream("src/by/teachmeskills/lesson16_xml_json/resources/books.xml");

      reader = inputFactory.createXMLStreamReader(input);
      List<Book> list = process(reader);

      for (Book book : list) {
        System.out.println(book.getTitle());
        System.out.println(book.getGenre());
      }
    } catch (XMLStreamException e) {
      e.printStackTrace();
    }
    return reader;

  }

  public static List<Book> process(XMLStreamReader reader)
      throws XMLStreamException {
    List<Book> menu = new ArrayList<>();
    Book book = null;
    BookTagName elementName = null;
    while (reader.hasNext()) {

      int type = reader.next();
      switch (type) {
        case XMLStreamConstants.START_ELEMENT:
          elementName = BookTagName.getElementTagName(reader
              .getLocalName());
          switch (elementName) {
            case BOOK:
              book = new Book();
              Integer id = Integer.parseInt(reader.getAttributeValue(
                  null, "id"));
              book.setId(id);
              break;
          }
          break;

        case XMLStreamConstants.CHARACTERS:
          String text = reader.getText().trim();

          if (text.isEmpty()) {
            break;
          }
          switch (elementName) {
            case TITLE:
              book.setTitle(text);
              break;
            case YEAR:
              Integer year = Integer.parseInt(text);
              book.setYear(year);
              break;
            case GENRE:
              book.setGenre(text);
              break;
            case AUTHOR:
              book.setAuthor(text);
              break;
          }
          break;

        case XMLStreamConstants.END_ELEMENT:
          elementName = BookTagName.getElementTagName(reader
              .getLocalName());
          switch (elementName) {

            case BOOK:
              menu.add(book);
          }

      }

    }
    return menu;
  }

}
