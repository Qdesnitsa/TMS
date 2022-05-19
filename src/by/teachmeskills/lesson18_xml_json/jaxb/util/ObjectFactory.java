package by.teachmeskills.lesson18_xml_json.jaxb.util;

import by.teachmeskills.lesson18_xml_json.jaxb.element.Book;
import by.teachmeskills.lesson18_xml_json.jaxb.element.BookRootElement;
import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public BookRootElement createBooks() {
        return new BookRootElement();
    }

    public Book createBook() {
        return new Book();
    }

}
