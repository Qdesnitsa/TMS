package by.teachmeskills.lesson16_xml_json.dom.main;

import static by.teachmeskills.lesson16_xml_json.dom.util.DOMBookWriter.domWrite;
import static by.teachmeskills.lesson16_xml_json.dom.util.DOMBookParser.domParse;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

public class MainDOM {
  private static String fileFrom = "src/by/teachmeskills/lesson16_xml_json/resources/books.xml";
  private static String fileTo = "src/by/teachmeskills/lesson16_xml_json/dom/output_xml/books.xml";

  public static void main(String[] args)
      throws IOException, SAXException, ParserConfigurationException, TransformerException {
    domParse(fileFrom);
    domWrite(fileTo);
  }
}
