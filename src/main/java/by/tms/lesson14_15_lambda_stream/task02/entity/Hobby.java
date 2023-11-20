package by.tms.lesson14_15_lambda_stream.task02.entity;

import java.util.Objects;

public class Hobby {
  private String name;
  private int score;

  public Hobby(String name, int score) {
    this.name = name;
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Hobby hobby = (Hobby) o;
    return score == hobby.score && Objects.equals(name, hobby.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, score);
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() +
        "name='" + name + '\'' +
        ", score=" + score;
  }
}
