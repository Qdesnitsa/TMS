package by.teachmeskills.lesson16_xml_json.jdom;

import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import java.util.Iterator;
import java.util.List;

public class JDOMBookParser {

  public static void main(String[] args) throws IOException, JDOMException {
    SAXBuilder builder = new SAXBuilder();
    Document document = builder.build("src/by/teachmeskills/lesson16_xml_json/resources/books.xml");

    Element root = document.getRootElement();
    List<Element> menu = root.getChildren();
    Iterator<Element> menuIterator = menu.iterator();
    while (menuIterator.hasNext()){
      Element bookElement = menuIterator.next();
      System.out.println(bookElement.getChildText("title") + ", " + bookElement.getChildText("author"));
    }
  }

}
