package by.teachmeskills.lesson16_xml_json.dom.main;

import static by.teachmeskills.lesson16_xml_json.dom.entity.DOMBookParser.domParse;
import static by.teachmeskills.lesson16_xml_json.dom.entity.DOMBookWriter.domWriter;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

public class MainDOM {
  private static String fileFrom = "src/by/teachmeskills/lesson16_xml_json/resources/books.xml";
  private static String fileTo = "src/by/teachmeskills/lesson16_xml_json/dom/entity/output_xml/books.xml";

  public static void main(String[] args)
      throws IOException, SAXException, ParserConfigurationException, TransformerException {
    domParse(fileFrom);
    domWriter(fileTo);
  }
}
