
package by.teachmeskills.lesson16_xml_json.jaxb;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public Books createNotes() {
        return new Books();
    }

    public Book createNote() {
        return new Book();
    }

}
