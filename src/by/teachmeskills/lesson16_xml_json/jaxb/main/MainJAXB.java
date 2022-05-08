package by.teachmeskills.lesson16_xml_json.jaxb.main;

import by.teachmeskills.lesson16_xml_json.jaxb.util.Marshal_Unmarshal;
import java.io.FileNotFoundException;
import javax.xml.bind.JAXBException;

public class MainJAXB {

  public static void main(String[] args) throws JAXBException, FileNotFoundException {
    Marshal_Unmarshal mu = new Marshal_Unmarshal();
    mu.unmarshal();
    mu.marshal();
  }

}
