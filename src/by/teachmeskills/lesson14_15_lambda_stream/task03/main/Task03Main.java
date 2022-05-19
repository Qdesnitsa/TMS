package by.teachmeskills.lesson14_15_lambda_stream.task03.main;

import static java.util.Arrays.asList;

import by.teachmeskills.lesson14_15_lambda_stream.task02.entity.Gender;
import by.teachmeskills.lesson14_15_lambda_stream.task02.entity.Hobby;
import by.teachmeskills.lesson14_15_lambda_stream.task02.entity.People;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task03Main {

  public static void main(String[] args) {
    Hobby hobby1 = new Hobby("IT", 10);
    Hobby hobby2 = new Hobby("Music", 6);
    Hobby hobby3 = new Hobby("Swimming", 8);
    Hobby hobby4 = new Hobby("Dancing", 7);
    Hobby hobby5 = new Hobby("Role-playing games", 5);

    List<People> peopleList = new ArrayList<>();
      peopleList.add(new People(10, "Bob", Gender.MALE, asList(hobby1, hobby2)));/////
      peopleList.add(new People(20, "Mark", Gender.MALE, asList(hobby3)));
      peopleList.add(new People(30, "Bill", Gender.MALE, asList(hobby1, hobby2, hobby3)));
      peopleList.add(new People(40, "Emma", Gender.FEMALE, asList(hobby2, hobby4)));
      peopleList.add(new People(60, "Isabella", Gender.FEMALE, asList(hobby1, hobby2, hobby4)));
      peopleList.add(new People(10, "Bob", Gender.MALE, asList(hobby1, hobby2)));/////
      peopleList.add(new People(50, "Jack", Gender.MALE, asList(hobby3,hobby4,hobby5)));
      peopleList.add(new People(80, "Olivia", Gender.FEMALE, null));
      peopleList.add(null);
      peopleList.add(null);
      peopleList.add(null);

    Map<String,People> peopleMap = new HashMap<>();
      peopleMap.put("Bob",new People(10, "Bob", Gender.MALE, asList(hobby1, hobby2)));/////
      peopleMap.put("Mark",new People(20, "Mark", Gender.MALE, asList(hobby3)));
      peopleMap.put("Bill",new People(30, "Bill", Gender.MALE, asList(hobby1, hobby2, hobby3)));
      peopleMap.put("Emma",new People(40, "Emma", Gender.FEMALE, asList(hobby2, hobby4)));
      peopleMap.put("Isabella",new People(60, "Isabella", Gender.FEMALE, asList(hobby1, hobby2, hobby4)));
      peopleMap.put("Bob",new People(10, "Bob", Gender.MALE, asList(hobby1, hobby2)));/////
      peopleMap.put("Jack",new People(50, "Jack", Gender.MALE, asList(hobby3,hobby4,hobby5)));
      peopleMap.put("Olivia",new People(80, "Olivia", Gender.FEMALE, null));
      peopleMap.put(null,null);
      peopleMap.put(null,null);
      peopleMap.put(null,null);

    System.out.println("List stream().distinct().forEach");
    peopleList.stream().distinct().forEach(System.out::println);
    System.out.println("List parallelStream().unordered().distinct().forEach");
    peopleList.parallelStream().unordered().distinct().forEach(System.out::println);
    System.out.println("Map parallelStream().distinct().forEachOrdered");
    peopleMap.entrySet().parallelStream().distinct().forEachOrdered(System.out::println);
    System.out.println("Map parallelStream().distinct().forEach");
    peopleMap.entrySet().parallelStream().distinct().forEach(System.out::println);
    System.out.println("Map stream().distinct().forEach");
    peopleMap.entrySet().stream().distinct().forEach(System.out::println);
    System.out.println("Map parallelStream().unordered().distinct().forEach");
    peopleMap.entrySet().parallelStream().unordered().distinct().forEach(System.out::println);
  }
}
