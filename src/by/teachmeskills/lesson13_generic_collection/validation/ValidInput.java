package by.teachmeskills.lesson13_generic_collection.validation;

import by.teachmeskills.lesson13_generic_collection.input.InputData;
import by.teachmeskills.lesson13_generic_collection.output.Printer;
import java.math.BigDecimal;

public final class ValidInput {
  private static final BigDecimal OBJECT_MAX_INT = BigDecimal.valueOf(Integer.MAX_VALUE);
  private static final BigDecimal OBJECT_MIN_INT = BigDecimal.valueOf(Integer.MIN_VALUE);
  private static String input;
  private static BigDecimal veryBigNumber;

  private ValidInput() {
  }

  private static final String VALID_INPUT = "[0-9]+";
  private static final String DELIMETER = " ";
  public static BigDecimal obtainInt(String data) {
    while (!data.matches(VALID_INPUT)) {
      Printer.printInvalidInput();
      input = InputData.obtainInput();
      String[] array = input.split(DELIMETER);
      data = array[0];
    }
    veryBigNumber = new BigDecimal(data);
    return veryBigNumber;
  }

  public static int checkOverflowInt(String data) {
    String input;
    veryBigNumber = obtainInt(data);
    while ((veryBigNumber.compareTo(OBJECT_MAX_INT) > 0) || (veryBigNumber.compareTo(OBJECT_MIN_INT) < 0)) {
      Printer.printInvalidInput();
      input = InputData.obtainInput();
      veryBigNumber = obtainInt(input);
    }
    return veryBigNumber.intValue();
  }

}
