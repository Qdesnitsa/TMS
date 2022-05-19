package by.teachmeskills.lesson18_xml_json.sax.main;

import by.teachmeskills.lesson18_xml_json.sax.entity.Book;
import by.teachmeskills.lesson18_xml_json.sax.util.BookSaxHandler;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class MainSAX {
  public static void main(String[] args) throws ParserConfigurationException,
      SAXException, IOException {

    SAXParserFactory parserFactory = SAXParserFactory.newInstance();
    SAXParser parser = parserFactory.newSAXParser();
    XMLReader reader = parser.getXMLReader();

    BookSaxHandler handler = new BookSaxHandler();
    reader.setContentHandler(handler);
    reader.parse(new InputSource("src/by/teachmeskills/lesson18_xml_json/resources/books.xml"));

    List<Book> list = handler.getBookList();

    for (Book food : list) {
      System.out.println(food.getTitle());
    }
  }
}
