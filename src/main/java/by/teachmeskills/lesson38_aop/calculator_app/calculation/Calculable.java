package by.teachmeskills.lesson38_aop.calculator_app.calculation;

import by.teachmeskills.lesson38_aop.calculator_app.calculation.exception.DivisionByZeroException;

public interface Calculable {
    static double sum(double a, double b) {
        return a + b;
    }

    static double diff(double a, double b) {
        return a - b;
    }

    static double multiply(double a, double b) {
        return a * b;
    }

    static double divide(double a, double b) throws DivisionByZeroException {
        if (b == 0.0D) {
            throw new DivisionByZeroException(" Division by zero is prohibited.");
        } else {
            return a / b;
        }
    }
}