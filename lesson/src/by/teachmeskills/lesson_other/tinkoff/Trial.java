package by.teachmeskills.lesson_other.tinkoff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class Trial {

  public static void main(String[] args) {

    int sum = add(checkNumber());
    System.out.println(sum);
  }

  private static List<String> fillNumber() {
    List<String> list = new ArrayList<>();
    String line = "";
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      while (list.size() < 2) {
        line = reader.readLine();
        list.add(line);
        }
      } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return list;
  }

  private static List<String> isOnlyDigits (List<String> list) {
    Pattern pattern = Pattern.compile("-?[\\d]+");
    while (!list.stream().allMatch(pattern.asPredicate())) {
      System.out.println("Line contains not only digits");
      list = fillNumber();
    }
    return list;
  }

    private static List<String> checkNumber() {
    List<String> list;
    list = isOnlyDigits(fillNumber());
      while (!list.stream().allMatch(s -> (Integer.parseInt(s) >= -32000 && Integer.parseInt(s) <= 32000))) {
        System.out.println("Number is out of the range");
        list = isOnlyDigits(fillNumber());
      }
      return list;
    }

    private static int add(List<String> list){
      return list.stream().mapToInt(p -> Integer.parseInt(p)).sum();
    }
  }



