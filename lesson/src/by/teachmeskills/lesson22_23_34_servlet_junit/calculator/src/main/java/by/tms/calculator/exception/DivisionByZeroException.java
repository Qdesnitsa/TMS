package by.tms.calculator.exception;

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
