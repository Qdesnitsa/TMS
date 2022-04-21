package by.teachmeskills.lesson11_exception_serialization.output;

public final class Printer {

  private static final String availableValue = "Allowed. Indicator is odd and equals: ";
  private static final String notAvailableValue = "Prohibited. Indicator is even and equals: ";

  private static StringBuilder builder = new StringBuilder();

  private Printer() {
  }

  public static StringBuilder printGoodMsg(int number) {
    builder.append(availableValue).append(number);
    System.out.println(builder);
    return builder;
  }

  public static StringBuilder printBadMsg(int number) {
    builder.append(notAvailableValue).append(number);
    return builder;
  }
}

