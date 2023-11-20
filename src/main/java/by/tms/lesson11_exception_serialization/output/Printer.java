package by.tms.lesson11_exception_serialization.output;

public final class Printer {

  private static final String AVAILABLE_VALUE = "Allowed. Indicator is odd and equals: ";
  private static final String NOT_AVAILABLE_VALUE = "Prohibited. Indicator is even and equals: ";

  private static StringBuilder builder = new StringBuilder();

  private Printer() {
  }

  public static StringBuilder printGoodMsg(int number) {
    builder.append(AVAILABLE_VALUE).append(number);
    System.out.println(builder);
    return builder;
  }

  public static StringBuilder printBadMsg(int number) {
    builder.append(NOT_AVAILABLE_VALUE).append(number);
    return builder;
  }
}

