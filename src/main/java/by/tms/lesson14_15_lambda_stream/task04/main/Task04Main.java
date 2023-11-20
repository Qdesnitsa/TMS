package by.tms.lesson14_15_lambda_stream.task04.main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Task04Main {

  public static void main(String[] args) {
    List<String> list = Arrays.asList("a1","a2","a3",null,"a1",null);

    // 1. Решение
    System.out.println("Task01: ");
    boolean checkedResult = checkHasElement(list,"a10");
    System.out.println(checkedResult);

    // 2. Аналогично решению 1.

    // 3. Решение
    System.out.println("Task03: ");
    boolean checkedResult2 = checkHasAllElement(list,"a");
    System.out.println(checkedResult2);

    // 4. Решение
    System.out.println("Task04: ");
    boolean checkedResult3 = checkHasNotElement(list,"a8");
    System.out.println(checkedResult3);
  }

  // 1. Найти существуют ли хоть один целевой элемент в коллекции.
  public static <T> boolean checkHasElement(List<T> list, T targetElement) {
    boolean result = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .anyMatch(targetElement::equals);
    return result;
  }

  // 3. Найти есть ли целевой символ у всех элементов коллекции.
  public static <T> boolean checkHasAllElement(List<T> list, T targetElement) {
    boolean result = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .allMatch(t -> t.toString().contains(targetElement.toString()));
    return result;
  }

  // 4. Проверить что не существуют ни одного целевого элемента в коллекции.
  public static <T> boolean checkHasNotElement(List<T> list, T targetElement) {
    boolean result = list.stream()
        .flatMap(s -> Stream.ofNullable(s))
        .noneMatch(targetElement::equals);
    return result;
  }
}
