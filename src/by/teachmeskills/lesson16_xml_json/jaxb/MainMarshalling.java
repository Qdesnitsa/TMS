package by.teachmeskills.lesson16_xml_json.jaxb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MainMarshalling {

  public static void main(String[] args) throws JAXBException, FileNotFoundException {
    JAXBContext context = JAXBContext.newInstance(BookRootElement.class);
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    BookRootElement book = new BookRootElement();
    book.getBook().add(createBook("The Lion, the Witch and the Wardrobe",1950,"Fantasy, Children's fiction","C. S. Lewis",6));
    marshaller.marshal(book, new FileOutputStream("./src/by/teachmeskills/lesson16_xml_json/jaxb/output_xml/books.xml"));
    marshaller.marshal(book,System.out);
    System.out.println("Done");
  }

  public static Book createBook(String title, int year, String genre, String author, int id) {
    Book book = new Book();
    book.setTitle(title);
    book.setYear(year);
    book.setGenre(genre);
    book.setAuthor(author);
    book.setId(id);
    return book;
  }

}
