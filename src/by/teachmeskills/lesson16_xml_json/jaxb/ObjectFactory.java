
package by.teachmeskills.lesson16_xml_json.jaxb;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public BookRootElement createNotes() {
        return new BookRootElement();
    }

    public Book createNote() {
        return new Book();
    }

}
