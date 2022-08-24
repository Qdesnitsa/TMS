package by.teachmeskills.lesson18_xml_json.stax.main;

import by.teachmeskills.lesson18_xml_json.stax.util.StAXBookParser;
import java.io.FileNotFoundException;
import javax.xml.stream.XMLStreamException;

public class MainStAX {

  public static void main(String[] args) throws FileNotFoundException, XMLStreamException {

    StAXBookParser.process(StAXBookParser.parse());
  }

}
