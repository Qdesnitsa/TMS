package by.teachmeskills.lesson16_xml_json.jaxb;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Main {
  public static void main(String[] args) throws JAXBException {

    File file = new File("./src/by/teachmeskills/lesson16_xml_json/jaxb/resources/books.xml");
    JAXBContext jaxbContext = JAXBContext.newInstance("by.teachmeskills.lesson16_xml_json.jaxb");

    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    BookRootElement books = (BookRootElement) jaxbUnmarshaller.unmarshal(file);

    for (Book book : books.getBook()) {
      System.out.println(book.getTitle());
    }

  }

}
