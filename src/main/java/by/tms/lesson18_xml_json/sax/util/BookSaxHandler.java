package by.tms.lesson18_xml_json.sax.util;

import by.tms.lesson18_xml_json.sax.entity.Book;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class BookSaxHandler extends DefaultHandler {
  private List<Book> bookList = new ArrayList<>();
  private Book book;
  private StringBuilder text;

  public List<Book> getBookList() {
    return bookList;
  }

  @Override
  public void startDocument() throws SAXException {
    System.out.println("Parsing started.");
  }

  @Override
  public void endDocument() throws SAXException {
    System.out.println("Parsing ended.");
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes)
      throws SAXException {
    System.out.println("startElement -> " + "uri: " + uri + ", localName: " + localName
        + ", qName: " + qName);
    text = new StringBuilder();
    if (qName.equals("book")){
      book = new Book();
      book.setId((Integer.parseInt(attributes.getValue("id"))));
    }
  }

  @Override
  public void characters(char[] buffer, int start, int length) throws SAXException {
    text.append(buffer, start, length);
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    BookTagName tagName = BookTagName.valueOf(qName.toUpperCase().replace(":", "_"));
    switch(tagName){
      case TITLE:
        book.setTitle(text.toString());
        break;
      case YEAR:
        book.setYear(Integer.parseInt(text.toString()));
        break;
      case GENRE:
        book.setGenre(text.toString());
        break;
      case AUTHOR:
        book.setAuthor(text.toString());
        break;
      case BOOK:
        bookList.add(book);
        book = null;
        break;
    }
  }

  public void warning(SAXParseException exception) {
    System.err.println("WARNING: line " + exception.getLineNumber() + ": "
        + exception.getMessage());
  }

  public void error(SAXParseException exception) {
    System.err.println("ERROR: line " + exception.getLineNumber() + ": "
        + exception.getMessage());
  }

  public void fatalError(SAXParseException exception) throws SAXException {
    System.err.println("FATAL: line " + exception.getLineNumber() + ": "
        + exception.getMessage());
    throw (exception);
  }

}
