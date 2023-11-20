package by.tms.lesson18_xml_json.validation;

import java.io.File;
import java.io.IOException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

public class XSDValidation {

  public static void main(String[] args) throws SAXException {
    SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
    File schemaLocation = new File("src/by/teachmeskills/lesson18_xml_json/resources/books.xsd");
    Schema schema = factory.newSchema(schemaLocation);
    Validator validator = schema.newValidator();
    Source source = new StreamSource("src/by/teachmeskills/lesson18_xml_json/resources/books.xml");
    try {
      validator.validate(source);
      System.out.println(" is valid.");
    } catch (SAXException | IOException ex) {
      System.out.println(" is not valid because ");
      System.out.println(ex.getMessage());
    }
  }

}
