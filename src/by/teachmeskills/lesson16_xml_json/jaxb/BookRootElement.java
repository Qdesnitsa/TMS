package by.teachmeskills.lesson16_xml_json.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "book"
})
@XmlRootElement(name = "books")
public class BookRootElement {

  @XmlElement(required = true)
  protected List<Book> book;

  public List<Book> getBook() {
    if (book == null) {
      book = new ArrayList<Book>();
    }
    return this.book;
  }

}
