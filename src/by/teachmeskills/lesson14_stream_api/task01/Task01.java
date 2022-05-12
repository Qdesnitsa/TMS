package by.teachmeskills.lesson14_stream_api.task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task01 {

  public static void main(String[] args) throws IllegalAccessException {
    List<String> listWithNull = new ArrayList<>();
    listWithNull.addAll(Arrays.asList("a1", "a2", "a3", null, null, "a1"));
//    List<Integer> listEmpty = new ArrayList<>();
//    List<String> listWithNullStartEndStr = new ArrayList<>();
//    listWithNullStartEndStr.addAll(Arrays.asList(null,"a1", "a2", "a3", null, null, "a10",null));

    Stream<String> streamWithNullStr;
//    Stream<Integer> streamEmptyInt;
//    Stream<String> streamNullStartEndStr;

    // 1. Решение
    System.out.println("Task1.1: ");
    String targetValue = "a1";
    int quantityTargetValue = countTargetValue(listWithNull, targetValue);
    System.out.println(quantityTargetValue);

    // 2. Решение
    System.out.println("Task1.2: ");
    streamWithNullStr = (Stream<String>) collectionAsStream(listWithNull);
    String firstTargetStr = obtainFirstTargetValue(streamWithNullStr,"0");
    System.out.println(firstTargetStr);

    // 3. Решение
    System.out.println("Task1.3: ");
    streamWithNullStr = (Stream<String>) collectionAsStream(listWithNull);
    String lastTargetStr = obtainLastTargetValue(streamWithNullStr, "empty");
    System.out.println(lastTargetStr);

    // 4. Решение
    System.out.println("Task1.4: ");
    String targetValue2 = "a3";
    streamWithNullStr = (Stream<String>) collectionAsStream(listWithNull);
    String tarVal2 = obtainTargetValue(streamWithNullStr, targetValue2);
    System.out.println(tarVal2);

    // 5. Решение
    System.out.println("Task1.5: ");
    Long targetPlace = 3L;
    streamWithNullStr = (Stream<String>) collectionAsStream(listWithNull);
    obtainNElement(streamWithNullStr,targetPlace);

    // 6. Решение
    System.out.println("Task1.6: ");
    targetPlace = 3L;
    Long quantityElements = 2L;
    streamWithNullStr = (Stream<String>) collectionAsStream(listWithNull);
    obtainExactNumberElement(streamWithNullStr,targetPlace,quantityElements);

    // 7. Решение
    System.out.println("Task1.7: ");
    String targetElem = "a1";
    streamWithNullStr = (Stream<String>) collectionAsStream(listWithNull);
    obtainAllTargetElem(streamWithNullStr,targetElem);
  }

  ////////////////////////////////////////////////////////////////

  // 0. Вернуть стрим без null.
  static Stream<?> collectionAsStream(Collection<?> collection) {
    return collection.stream().flatMap(s -> Stream.ofNullable(s));
  }

  // 1. Вернуть количество вхождений объекта «a1».
  public static <T> int countTargetValue(List<?> list, T targetValue) {
    int quantityTargetValue = (int) collectionAsStream(list).filter(
        element -> element.equals(targetValue)).count();
    
    return quantityTargetValue;
  }

  // 2. Вернуть первый элемент коллекции или 0, если коллекция пуста.
  public static <T> T obtainFirstTargetValue(Stream<T> stream, T replaceValue) {
   T firstTarget = stream.findFirst().orElse(replaceValue);
   return (T) firstTarget;
  }

  // 3. Вернуть последний элемент коллекции или «empty», если коллекция пуста.
  public static <T> T obtainLastTargetValue(Stream<T> stream, T replaceValue) {
    T lastTarget = stream.reduce((x,y) -> y).orElse(replaceValue);
    return lastTarget;
  }

  // 4. Найти элемент в коллекции равный «a3» или кинуть ошибку.
  public static <T> T obtainTargetValue(Stream<T> stream, T targetValue)
      throws IllegalAccessException {
    Optional<T> isInList = stream.filter(s->s.equals(targetValue)).findAny();
    return isInList.orElseThrow(IllegalAccessException::new);
  }

  // 5. Вернуть третий элемент коллекции по порядку.
  public static <T> void obtainNElement(Stream<T> stream, Long targetPlace) {
    stream.skip(--targetPlace).limit(1).forEach(s-> System.out.println(s));
  }

  // 6. Вернуть два элемента начиная со второго - [a2, a3].
  public static <T> void obtainExactNumberElement(Stream<T> stream, Long targetPlace, Long quantityElements) {
    stream.skip(--targetPlace).limit(quantityElements).forEach(s-> System.out.println(s));
  }

  // 7. Выбрать все элементы по шаблону.
  public static <T> void obtainAllTargetElem(Stream<T> stream, T targetElem) {
    List<T> listAfterFilter = stream.filter(s->s.equals(targetElem)).collect(Collectors.toList());
    System.out.println(listAfterFilter);
  }
}
