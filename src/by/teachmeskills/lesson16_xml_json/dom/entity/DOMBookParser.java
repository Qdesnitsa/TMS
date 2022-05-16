package by.teachmeskills.lesson16_xml_json.dom.entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMBookParser {
  public static void domParse(String fileFrom) throws IOException, SAXException {
    DOMParser parser = new DOMParser();
    parser.parse(fileFrom);
    Document document = parser.getDocument();

    Element root = document.getDocumentElement();

    List<Book> bookList = new ArrayList<>();

    NodeList bookNodes = root.getElementsByTagName("book");
    Book book = null;
    for (int i = 0; i < bookNodes.getLength(); i++) {
      book = new Book();
      Element bookElement = (Element) bookNodes.item(i);
      book.setId(Integer.parseInt(bookElement.getAttribute("id")));
      book.setTitle(getSingleChild(bookElement, "title").getTextContent().trim());
      book.setYear(Integer.parseInt(getSingleChild(bookElement, "year").getTextContent().trim()));
      book.setGenre(getSingleChild(bookElement, "genre").getTextContent().trim());
      book.setAuthor(getSingleChild(bookElement, "author").getTextContent().trim());
      bookList.add(book);
    }

    for (Book b :bookList) {
      System.out.println(b.getTitle() + ", " + b.getAuthor() + ", " + b.getGenre());
    }
  }

  private static Element getSingleChild(Element element, String childName) {
    NodeList nlist = element.getElementsByTagName(childName);
    Element child = (Element) nlist.item(0);
    return child;
  }
}
