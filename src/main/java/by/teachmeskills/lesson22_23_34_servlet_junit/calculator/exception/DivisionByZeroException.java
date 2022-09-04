package by.teachmeskills.lesson22_23_34_servlet_junit.calculator.exception;

public class DivisionByZeroException extends Exception {
    private String reasonMsg;

    public DivisionByZeroException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + reasonMsg;
    }
}
