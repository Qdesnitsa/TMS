package by.teachmeskills.lesson38_aop.calculator_app.util.output;

public final class OutputConsole {
  private static final String INPUT_INSTRUCTION_FOR_USER =
          "Enter expression using: numbers,+,-,*,/,(,) without spaces. Quantity of '(' and ')' should be equal.";

  private OutputConsole() {
  }

  /**
   * Метод выводит на консоль сообщение пользователю с инструкцией для ввода данных.
   */
  public static void printInstructions() {
    System.out.println(INPUT_INSTRUCTION_FOR_USER);
  }

  /**
   * Метод выводит результат вычислений.
   * @param result результат вычисления.
   */
  public static void printResultingMsg(String  result) {
    System.out.println(result);
  }
}
