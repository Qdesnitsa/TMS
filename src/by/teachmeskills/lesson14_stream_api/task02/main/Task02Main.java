package by.teachmeskills.lesson14_stream_api.task02.main;

import static java.util.Arrays.asList;

import by.teachmeskills.lesson14_stream_api.task02.entity.Gender;
import by.teachmeskills.lesson14_stream_api.task02.entity.Hobby;
import by.teachmeskills.lesson14_stream_api.task02.entity.People;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task02Main {

  public static void main(String[] args) {
    Hobby hobby1 = new Hobby("IT", 10);
    Hobby hobby2 = new Hobby("Music", 6);
    Hobby hobby3 = new Hobby("Swimming", 8);
    Hobby hobby4 = new Hobby("Dancing", 7);
    Hobby hobby5 = new Hobby("Role-playing games", 5);

    List<People> peopleList = asList(
        new People(10, "Bob", Gender.MALE, asList(hobby1, hobby2)),
        new People(20, "Mark", Gender.MALE, asList(hobby3)),
        new People(30, "Bill", Gender.MALE, asList(hobby1, hobby2, hobby3)),
        new People(40, "Emma", Gender.FEMALE, asList(hobby2, hobby4)),
        new People(60, "Isabella", Gender.FEMALE, asList(hobby1, hobby2, hobby4)),
        new People(60, "Tom", Gender.MALE, asList(hobby2)),
        new People(50, "Jack", Gender.MALE, asList(hobby3,hobby4,hobby5)),
        new People(80, "Olivia", Gender.FEMALE, null),
        null,
        null,
        null);

    // 1. Решение
    obtainListAgeRangeAndGender(peopleList, 30, 40, Gender.MALE);

    // 2. Решение
    double avgAge = obtainAvgAgeAndGender(peopleList, Gender.MALE);
    System.out.println(avgAge);

    // 3. Решение
    List<People> workingPeople = peopleEachGenderAgeRange(peopleList, 18, 55, 18, 60);

    // 4. Решение
    System.out.println("TaskN: ");
    List<People> sortedHobbyAge = sortQuantityHobbyAge(peopleList);

    // 5. Решение
    System.out.println("Task06.5: ");
    sortNamesDesc(peopleList);

    // 6. Решение
    System.out.println("Task06.6");
    sortGenderAgeAsc(peopleList);

    // 7. Решение
    System.out.println("Task07: ");
    obtainPeopleMaxAge(peopleList);

    // 8. Решение
    System.out.println("Task08: ");
    obtainListScoreHobby(peopleList,Gender.FEMALE,7.0,2,Gender.MALE,7.0,2);
  }

  ///////////////////////////////////////////////////////////////////////////////////

  // 1. Сделать выборку по нескольким условиям.
  public static List<People> obtainListAgeRangeAndGender(List<People> list, int startAge,
      int endAge, Gender gender) {
    Predicate<People> fromAge = a1 -> a1.getAge() >= startAge;
    Predicate<People> toAge = a2 -> a2.getAge() <= endAge;
    Predicate<People> genderType = a3 -> a3.getGender().equals(gender);
    List<People> peopleListAge = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .filter(fromAge.and(toAge.and(genderType)))
        .peek(s -> System.out.println(s))
        .collect(Collectors.toList());
    return peopleListAge;
  }

  // 2. Найти среднее значение возраста и еще какой-нибудь фильтр.
  public static double obtainAvgAgeAndGender(List<People> list, Gender gender) {
    Predicate<People> genderType = a3 -> a3.getGender().equals(gender);
    double peopleAvgAge = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .filter(genderType)
        .mapToInt(a -> a.getAge()).average().getAsDouble();
    return peopleAvgAge;
  }

  // 3. Реализовать выборку по возрасту по каждому гендеру.
  public static List<People> peopleEachGenderAgeRange(List<People> list, int femaleStartAge,
      int femaleEndAge, int maleStartAge, int maleEndAge) {
    List<People> peopleList;
    Predicate<People> female = a -> a.getGender().equals(Gender.FEMALE);
    Predicate<People> male = a -> a.getGender().equals(Gender.MALE);
    Predicate<People> startAge1 = a -> a.getAge() >= femaleStartAge;
    Predicate<People> endAge1 = a -> a.getAge() <= femaleEndAge;
    Predicate<People> startAge2 = a -> a.getAge() >= maleStartAge;
    Predicate<People> endAge2 = a -> a.getAge() <= maleEndAge;
    Stream<People> resultStream = Stream.concat(
            list.stream().flatMap(s -> Stream.ofNullable(s)).filter(male.and(startAge2.and(endAge2))),
            list.stream().flatMap(s -> Stream.ofNullable(s)).filter(female.and(startAge1.and(endAge1))));
    peopleList = resultStream.peek(s-> System.out.println(s)).collect(Collectors.toList());
    return peopleList;
  }

  // 4. Сортировать по количеству хобби потом по возрасту.
  public static List<People> sortQuantityHobbyAge(List<People> list) {
    List<People> targetList = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .sorted((p1,p2) -> p1.getSizeList().equals(p2.getSizeList()) ?
        p1.getAge().compareTo(p2.getAge()) :
            p1.getSizeList().compareTo(p2.getSizeList()))
        .peek(System.out::println)
        .collect(
        Collectors.toList());
    return targetList;
  }

  // 5. Отсортировать коллекцию людей по имени в обратном алфавитном порядке.
  public static List<People> sortNamesDesc(List<People> list) {
    List<People> targetList = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .sorted((p1,p2) -> p2.getName().compareTo(p1.getName()))
        .peek(System.out::println)
        .collect(Collectors.toList());
    return targetList;
  }

  // 6. Отсортировать коллекцию людей сначала по полу потом по возрасту.
  public static List<People> sortGenderAgeAsc(List<People> list) {
    List<People> targetList = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .sorted((p1,p2) -> p1.getGender().equals(p2.getGender()) ? p1.getAge().compareTo(p2.getAge()) : p1.getGender().compareTo(p2.getGender()))
        .peek(System.out::println)
        .collect(Collectors.toList());
    return targetList;
  }

  // 7. Найти всех людей с максимальным возрастом.
  public static List<People> obtainPeopleMaxAge(List<People> list) {
    int maxAge = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .mapToInt(p -> p.getAge())
        .max()
        .orElse(-100);
    List<People> targetPeople = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .filter(f -> f.getAge() == maxAge)
        .peek(System.out::println)
        .collect(Collectors.toList());
    return targetPeople;
  }

  // 8. Найти всех людей со средней оценкой выше какого-нибудь значения и количеством хобби более какого-либо значения.
  // Для разных гендеров разные условия.
  public static List<People> obtainListScoreHobby(List<People> list, Gender gender1, Double score1, int hobby1, Gender gender2, Double score2, int hobby2) {
    List<People> targetList = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .filter(p ->
            p.getGender().equals(gender1) &&
            p.getSizeList() >= hobby1 &&
            p.getListHobby().stream().flatMap(s -> Stream.ofNullable(s)).mapToInt(Hobby::getScore).average().getAsDouble() > score1 ||
                p.getGender().equals(gender2) &&
                    p.getSizeList() >= hobby2 &&
                    p.getListHobby().stream().flatMap(s -> Stream.ofNullable(s)).mapToInt(Hobby::getScore).average().getAsDouble() > score2)
        .peek(System.out::println)
        .collect(Collectors.toList());
    return targetList;
  }
}
