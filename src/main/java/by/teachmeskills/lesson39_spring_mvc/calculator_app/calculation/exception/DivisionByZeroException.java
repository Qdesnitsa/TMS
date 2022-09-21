package by.teachmeskills.lesson39_spring_mvc.calculator_app.calculation.exception;

public class DivisionByZeroException extends Exception {
    private String reasonMsg;

    public DivisionByZeroException() {
        super();
    }

    public DivisionByZeroException(String message) {
        super(message);
    }

    public DivisionByZeroException(Throwable cause) {
        super(cause);
    }

    public DivisionByZeroException(String message, Throwable cause) {
        super(message, cause);
    }
}
