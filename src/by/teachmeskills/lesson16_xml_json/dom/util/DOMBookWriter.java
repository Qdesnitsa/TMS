package by.teachmeskills.lesson16_xml_json.dom.util;

import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DOMBookWriter {
  public static void domWrite(String fileTo)
      throws ParserConfigurationException, TransformerException, IOException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.newDocument();

    Element books = document.createElementNS("http://www.teachmeskills.by/books","books");
    books.setPrefix("b");
    books.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance","xsi:schemaLocation","http://www.teachmeskills.by/books ../../resources/books.xsd");

    Element book = document.createElement("book");
    book.setAttribute("id", "01");

    Element title = document.createElement("title");
    title.setTextContent("The Little Prince");

    Element year = document.createElement("year");
    year.setTextContent("1943");

    Element genre = document.createElement("genre");
    genre.setTextContent("Novella");

    Element author = document.createElement("author");
    author.setTextContent("Antoine de Saint-Exupery");

    book.appendChild(title);
    book.appendChild(year);
    book.appendChild(genre);
    book.appendChild(author);
    books.appendChild(book);
    document.appendChild(books);

    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    DOMSource source = new DOMSource(document);
    StreamResult result = new StreamResult(new FileWriter(fileTo));
    transformer.transform(source, result);
  }

}
