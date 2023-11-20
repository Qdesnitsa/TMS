package by.tms.lesson18_xml_json.dom.main;

import static by.tms.lesson18_xml_json.dom.util.DOMBookWriter.domWrite;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import by.tms.lesson18_xml_json.dom.util.DOMBookParser;
import org.xml.sax.SAXException;

public class MainDOM {
  private static String fileFrom = "src/by/teachmeskills/lesson18_xml_json/resources/books.xml";
  private static String fileTo = "src/by/teachmeskills/lesson18_xml_json/dom/output_xml/books.xml";

  public static void main(String[] args)
      throws IOException, SAXException, ParserConfigurationException, TransformerException {
    DOMBookParser.domParse(fileFrom);
    domWrite(fileTo);
  }
}
