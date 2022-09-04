package by.teachmeskills.lesson14_15_lambda_stream.task02.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class People {
  private int age;
  private String name;
  private Gender gender;
  private List<Hobby> listHobby;

  public People(int age, String name,
      Gender gender,
      List<Hobby> listHobby) {
    this.age = age;
    this.name = name;
    this.gender = gender;
    this.listHobby = listHobby;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public List<Hobby> getListHobby() {
    return (listHobby == null) ? new ArrayList<>() : listHobby;
  }


  public void setListHobby(
      List<Hobby> listHobby) {
    this.listHobby = listHobby;
  }

  public Integer getSizeList() {
    if (getListHobby() == null) {
      return 0;
    }
    return getListHobby().size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    People people = (People) o;
    return age == people.age && Objects.equals(name, people.name) && gender == people.gender
        && Objects.equals(listHobby, people.listHobby);
  }

  @Override
  public int hashCode() {
    return Objects.hash(age, name, gender, listHobby);
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() +
        "age=" + age +
        ", name='" + name + '\'' +
        ", gender=" + gender +
        ", listHobby=" + listHobby;
  }
}
