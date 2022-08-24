package by.teachmeskills.lesson18_xml_json.jdom;

import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDOMCreateXML {

  public static void main(String[] args) throws IOException {
    Element root = new Element("books");
    Element book = new Element("book");
    book.setAttribute("id", "01");
    Element title = new Element("title");
    title.setText("The Little Prince");
    Element year = new Element("year");
    year.setText("1943");
    Element genre = new Element("genre");
    genre.setText("Novella");
    Element author = new Element("author");
    author.setText("Antoine de Saint-Exupery");
    book.addContent(title);
    book.addContent(year);
    book.addContent(genre);
    book.addContent(author);
    root.addContent(book);
    Document document = new Document(root);
    XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
    outputter.output(document, new FileOutputStream("src/by/teachmeskills/lesson18_xml_json/jdom/output_books.xml"));
  }

}
