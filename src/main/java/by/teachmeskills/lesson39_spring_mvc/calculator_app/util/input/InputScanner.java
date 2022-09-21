package by.teachmeskills.lesson39_spring_mvc.calculator_app.util.input;

import java.util.Scanner;

public final class InputScanner {
    private static String input;

    private InputScanner() {
    }

    /**
     * Метод принимает от пользователя с консоли строку с любыми символами.
     *
     * @return строку без изменений.
     */
    public static String obtainStringInput() {
        @SuppressWarnings("unchecked")
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        return input;
    }

}
