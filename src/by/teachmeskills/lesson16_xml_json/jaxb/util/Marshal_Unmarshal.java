package by.teachmeskills.lesson16_xml_json.jaxb.util;

import by.teachmeskills.lesson16_xml_json.jaxb.element.Book;
import by.teachmeskills.lesson16_xml_json.jaxb.element.BookRootElement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Marshal_Unmarshal {
  static BookRootElement books;

  public void marshal() throws JAXBException, FileNotFoundException {
    JAXBContext context = JAXBContext.newInstance(BookRootElement.class);
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    books.getBook().add(createBook("The Lion, the Witch and the Wardrobe",1950,"Fantasy, Children's fiction","C. S. Lewis",6));
    marshaller.marshal(books, new FileOutputStream("./src/by/teachmeskills/lesson16_xml_json/jaxb/output_xml/books.xml"));
    //marshaller.marshal(books,System.out);
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

  public void unmarshal() throws JAXBException {
    File file = new File("./src/by/teachmeskills/lesson16_xml_json/jaxb/resources/books.xml");
    JAXBContext jaxbContext = JAXBContext.newInstance("by.teachmeskills.lesson16_xml_json.jaxb.util");

    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    books = (BookRootElement) jaxbUnmarshaller.unmarshal(file);

//    for (Book book : books.getBook()) {
//      System.out.println(book.getTitle());
//    }
  }

}
