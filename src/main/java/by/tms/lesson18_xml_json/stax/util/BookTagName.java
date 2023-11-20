package by.tms.lesson18_xml_json.stax.util;

public enum BookTagName {
  BOOK, TITLE, YEAR, GENRE, AUTHOR, BOOKS;

  public static BookTagName getElementTagName(String element) {
    switch (element) {
      case "book":
        return BOOK;
      case "title":
        return TITLE;
      case "year":
        return YEAR;
      case "genre":
        return GENRE;
      case "author":
        return AUTHOR;
      case "books":
        return BOOKS;
      default:
        throw new EnumConstantNotPresentException(BookTagName.class,
            element);
    }
  }
}
