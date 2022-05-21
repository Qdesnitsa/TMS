package by.teachmeskills.lesson18_xml_json.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
  @JsonIgnore
  private int id;

  @JsonProperty("Title")
  private String title;

  @JsonProperty("Year of first publishing")
  private int year;

  @JsonProperty("Genre")
  private String genre;

  @JsonProperty("Author")
  private String author;

  public Book() {}

  public Book(int id, String title, int year, String genre, String author) {
    this.id = id;
    this.title = title;
    this.year = year;
    this.genre = genre;
    this.author = author;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() +
        "id=" + id +
        ", title='" + title + '\'' +
        ", year=" + year +
        ", genre='" + genre + '\'' +
        ", author='" + author + '\'' +
        '}';
  }
}
