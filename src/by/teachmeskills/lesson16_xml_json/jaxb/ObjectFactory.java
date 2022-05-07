package by.teachmeskills.lesson16_xml_json.jaxb;

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
