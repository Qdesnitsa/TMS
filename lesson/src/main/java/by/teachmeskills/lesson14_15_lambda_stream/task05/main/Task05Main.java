package by.teachmeskills.lesson14_15_lambda_stream.task05.main;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task05Main {

  public static void main(String[] args) {
    String str = "Hello";
    
    Stream.of(str.toCharArray()).collect(Collectors.groupingBy(r->r,Collectors.counting())).forEach((k,v)-> System.out.println());
    List<String> list1 = Arrays.asList("a1", "b2", "a3", null, "a1", null);
    List<String> list2 = Arrays.asList(null, "8,2,0", "4,9,7,1");

    // 1. Решение
    System.out.println("Task01: ");
    addSimbolToElements(list1, "_1");

    // 2. Решение
    System.out.println("Task02: ");
    removeSymbolFromElement(list1, 2);

    // 3. Решение
    System.out.println("Task03: ");
    List<Integer> listNumbers = obtainNumbers(list2, ",");

    // 4. Решение
    System.out.println("Task04: ");
    int sum = obtainSum(list2, ",");
    System.out.println(sum);

    // 5. Решение
    System.out.println("Task05: ");
    String maxValue = obtainMaxValue(list1);
    System.out.println(maxValue);

    // 6. Решение
    System.out.println("Task06: ");
    String minValue = obtainMinValue(list1);
    System.out.println(minValue);

    // 7. Решение
    System.out.println("Task07: ");
    sortAscWithDuplicates(list1);

    // 8. Решение
    System.out.println("Task08: ");
    sortAscNoDuplicates(list1);

    // 9. Решение
    System.out.println("Task09: ");
    sortDescWithDuplicates(list1);

    // 10. Решение
    System.out.println("Task10: ");
    sortDescNoDuplicates(list1);

    // 11. Решение
    System.out.println("Task11: ");
    System.out.println(obtainSumNumbers(listNumbers));

    // 12. Решение
    System.out.println("Task12: ");
    System.out.println(obtainBiggestNumber(listNumbers));

    // 13. Решение
    System.out.println("Task13: ");
    System.out.println(obtainOddNumbers(listNumbers));

    // 14. Решение
    System.out.println("Task14: ");
    System.out.println(obtainSumOddNumbers(listNumbers));

    // 15. Решение
    System.out.println("Task15: ");
    System.out.println(substractAndAvg(listNumbers,1.0));

    // 16. Решение
    System.out.println("Task16: ");
    System.out.println(addAndStatistics(listNumbers,3.0));

    // 17. Решение
    System.out.println("Task17: ");
    System.out.println(partitionOddEven(listNumbers));

    // 18. Решение
    System.out.println("Task18: ");
    System.out.println(obtainListUpperCaseNoDuplicates(list1));

    // 19. Решение
    System.out.println("Task19: ");
    System.out.println(joinAndWrap(list1,"|","<p>","</p>"));

    // 20. Решение
    System.out.println("Task20: ");
    System.out.println(obtainMap(list1));

    // 21. Решение
    System.out.println("Task21: ");
    System.out.println(obtainMapKeyFirstChar(list1));

    // 22. Решение
    System.out.println("Task22: ");
    System.out.println(obtainMapKeyFirstCharDelimeterValues(list1,"|"));
  }

  // 1. Добавить "_1" к каждому элементу первой коллекции.
  public static List<String> addSimbolToElements(List<String> list, String targetSymbol) {
    List<String> targetList = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .map(p -> p.concat(targetSymbol)).peek(System.out::println)
        .collect(Collectors.toList());
    return targetList;
  }

  // 2. В первой коллекции убрать первый символ и вернуть массив чисел.
  public static List<String> removeSymbolFromElement(List<String> list, int targetDeletion) {
    List<String> targetList = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .map(p -> p.substring(1)).peek(System.out::println)
        .collect(Collectors.toList());
    return targetList;
  }

  // 3. Из второй коллекции получить все числа, перечисленные через запятую из всех элементов.
  public static List<Integer> obtainNumbers(List<String> list, String delimeter) {
    List<Integer> targetList = (List<Integer>) list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .flatMap(t -> Arrays.asList(t.split(delimeter))
            .stream().map(p -> Integer.parseInt(p)))
        .peek(System.out::println)
        .collect(Collectors.toList());
    return targetList;
  }

  // 4. Из второй коллекции получить сумму всех чисел, перечисленных через запятую.
  public static int obtainSum(List<String> list, String delimeter) {
    int targetSum = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .flatMapToInt(t -> Arrays.asList(t.split(delimeter))
            .stream()
            .mapToInt(p -> Integer.parseInt(p)))
        .sum();
    return targetSum;
  }

  // 5. Найти максимальное значение среди коллекции строк.
  public static String obtainMaxValue(List<String> list) {
    String targetValue = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .max(String::compareTo).get();
    return targetValue;
  }

  // 6. Найти минимальное значение среди коллекции строк.
  public static String obtainMinValue(List<String> list) {
    String targetValue = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .min(String::compareTo).get();
    return targetValue;
  }

  // 7. Отсортировать коллекцию строк по алфавиту.
  public static List<?> sortAscWithDuplicates(List<?> list) {
    List<?> targetList = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .sorted()
        .peek(System.out::println)
        .collect(Collectors.toList());
    return targetList;
  }

  // 8. Отсортировать коллекцию строк по алфавиту без дубликотов
  public static List<?> sortAscNoDuplicates(List<?> list) {
    List<?> targetList = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .sorted()
        .distinct()
        .peek(System.out::println)
        .collect(Collectors.toList());
    return targetList;
  }

  // 9. Отсортировать коллекцию строк по алфавиту в обратном порядке.
  public static List<?> sortDescWithDuplicates(List<?> list) {
    List<?> targetList = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .sorted((p1, p2) -> p2.toString().compareTo(p1.toString()))
        .peek(System.out::println)
        .collect(Collectors.toList());
    return targetList;
  }

  // 10. Отсортировать коллекцию строк по алфавиту в обратном порядке без дубликатов.
  public static List<?> sortDescNoDuplicates(List<?> list) {
    List<?> targetList = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .sorted((p1, p2) -> p2.toString().compareTo(p1.toString()))
        .distinct()
        .peek(System.out::println)
        .collect(Collectors.toList());
    return targetList;
  }

  // 11. Получить сумму чисел или вернуть 0.
  public static int obtainSumNumbers(List<Integer> list) {
    int targetSum = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .reduce((x, y) -> x + y)
        .orElse(0);
    return targetSum;
  }

  // 12. Вернуть максимум или -1.
  public static int obtainBiggestNumber(List<Integer> list) {
    int targetValue = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .reduce((p1, p2) -> Integer.max(p1, p2))
        .orElse(-1);
    return targetValue;
  }

  // 13. Вернуть сумму нечётных чисел или 0.
  public static int obtainOddNumbers(List<Integer> list) {
    int targetValue = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .filter(t -> t % 2 != 0)
        .reduce((p1,p2) -> p1 + p2)
        .orElse(0);
    return targetValue;
  }

  // 14. Получить сумму нечётных чисел.
  public static int obtainSumOddNumbers(List<Integer> list) {
    int targetValue = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .collect(Collectors.summingInt(p -> p % 2 != 0 ? p : 0));
    return targetValue;
  }

  // 15. Вычесть из каждого элемента целевое число и получить среднее.
  public static double substractAndAvg(List<Integer> list, Double number) {
    double targetValue = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .collect(Collectors.averagingDouble(p -> p - number));
    return targetValue;
  }

  // 16. Прибавить к числам целевое число и получить статистику.
  public static DoubleSummaryStatistics addAndStatistics(List<Integer> list, Double number) {
    DoubleSummaryStatistics targetStat = list.stream()
        .collect(Collectors.summarizingDouble(p -> p + number));
    return targetStat;
  }

  // 17. Разделить числа на чётные и нечётные.
  public static Map<Boolean,List<Integer>> partitionOddEven(List<Integer> list) {
    Map<Boolean,List<Integer>> targetMap = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .collect(Collectors.partitioningBy(p -> p % 2 != 0));
    return targetMap;
  }

  // 18. Получить массив строк без дубликатов и в верхнем регистре.
  public static List<String> obtainListUpperCaseNoDuplicates(List<String> list) {
    List<String> targetList = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .distinct()
        .map(p -> p.toUpperCase())
        .collect(Collectors.toList());
    return targetList;
  }

  // 19. Объединить все элементы в одну строку через разделитель: и обернуть тегами <b>… </b>.
  public static String joinAndWrap(List<String> list, String delimeter, String prefix, String suffix) {
    String targetString = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .collect(Collectors.joining(delimeter,prefix,suffix));
    return targetString;
  }

  // 20. Преобразовать в map, где первый символ ключ, второй символ значение.
  public static Map<String,String> obtainMap(List<String> list) {
    Map<String,String> targetMap = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .distinct()
        .collect(Collectors.toMap(k -> k.substring(0,1), v -> v.substring(1,2), (x,y) -> x));
    return targetMap;
  }

  // 21. Преобразовать в map, сгруппировав по первому символу строки.
  public static Map<String,List<String>> obtainMapKeyFirstChar(List<String> list) {
    Map<String,List<String>> targetMap = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .collect(Collectors.groupingBy(p -> p.substring(0,1)));
    return targetMap;
  }

  // 22. Преобразовать в map, сгруппировав по первому символу строки и объединим вторые символы через разделитель.
  public static Map<String,String> obtainMapKeyFirstCharDelimeterValues(List<String> list, String delimeter) {
    Map<String,String> targetMap = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .collect(Collectors.groupingBy(p -> p.substring(0,1),Collectors.mapping(p -> p.substring(1,2),Collectors.joining(delimeter))));
    return targetMap;
  }
}
