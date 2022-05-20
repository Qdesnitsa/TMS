package by.teachmeskills.lesson_other.lambda_stream;

import by.teachmeskills.lesson14_15_lambda_stream.task02.entity.Gender;
import by.teachmeskills.lesson14_15_lambda_stream.task02.entity.Hobby;
import by.teachmeskills.lesson14_15_lambda_stream.task02.entity.People;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ClassWork {

  public static void main(String[] args) {
    Hobby hobby1 = new Hobby("IT", new Random().nextInt(11));
    Hobby hobby2 = new Hobby("Movie", new Random().nextInt(11));
    Hobby hobby3 = new Hobby("Squash", new Random().nextInt(11));

    People people1 = new People(22, "Danbiil", Gender.MALE, List.of(hobby1, hobby2));
    People people2 = new People(18, "Klim", Gender.MALE, List.of(hobby1));
    People people3 = new People(35, "Victor", Gender.MALE, List.of(hobby1, hobby3));
    People people4 = new People(23, "Artyom", Gender.MALE, List.of(hobby3, hobby2));
    People people5 = new People(20, "Nastia", Gender.FEMALE, List.of(hobby1, hobby2, hobby3));

    List<People> peoples = List.of(people1, people2, people3, people4, people5);

    //Task1
    double average = peoples.stream().mapToInt(People::getAge).average().orElse(0);

    //Task2
    List<People> malePeople = peoples.stream()
        .filter(people -> people.getGender() == Gender.MALE)
        .collect(Collectors.toList());

    //Task3
    List<People> hobPeople = peoples.stream()
        .filter(people -> people.getListHobby().stream()
            .anyMatch(hobby -> hobby.getName().equals("IT")))
        .collect(Collectors.toList());

    //Task4
    List<People> hobPeopleAv = peoples.stream()
        .filter(people -> people.getListHobby().size() >= 2)
        .filter(p -> p.getListHobby().stream()
            .filter(hobby -> hobby.getScore() > 1).peek(System.out::println)
            .collect(Collectors.toList()).size() >= 2)
        .collect(Collectors.toList());

    //Task5
    peoples.stream()
        .filter(p -> PeopleBirthdayInfo.isLeapYear(p.getAge()))
        .forEach(System.out::println);

    //Task6
    peoples.stream().filter(p -> {
          String nameToLowerCase = p.getName().toLowerCase();
          return nameToLowerCase.contains("a") && !nameToLowerCase.contains("b");
        })
        .forEach(System.out::println);

    //Task7
    peoples.stream()
        .sorted(Comparator.comparing(People::getName).reversed())
        .forEach(System.out::println);

    //Task8
    peoples.stream()
        .sorted(Comparator.comparing(People::getSizeList))
        .forEach(System.out::println);

    //Task9
    peoples.stream().
        min(Comparator.comparingInt(People::getAge)
            .reversed()
            .thenComparing((People::getSizeList)));

    //Task10
    String hello = "Hello";
    Arrays.stream(hello.split(""))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .forEach((k, v) -> System.out.printf("%s=%d", k, v));
  }
}

class PeopleBirthdayInfo {

  public static boolean isLeapYear(int age) {
    return LocalDate.now().minusYears(age).isLeapYear();
  }
}
