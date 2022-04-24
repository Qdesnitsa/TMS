package by.teachmeskills.lesson13_generic_collection.validation;

import by.teachmeskills.lesson13_generic_collection.input.InputData;
import by.teachmeskills.lesson13_generic_collection.output.Printer;
import java.math.BigDecimal;

public class ValidInput {
  private static final BigDecimal objectMaxInt = BigDecimal.valueOf(Integer.MAX_VALUE);
  private static final BigDecimal objectMinInt = BigDecimal.valueOf(Integer.MIN_VALUE);
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
    while ((veryBigNumber.compareTo(objectMaxInt) > 0) || (veryBigNumber.compareTo(objectMinInt) < 0)) {
      Printer.printInvalidInput();
      input = InputData.obtainInput();
      veryBigNumber = obtainInt(input);
    }
    return veryBigNumber.intValue();
  }

}
