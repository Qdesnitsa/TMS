package by.teachmeskills.lesson22_23_34_servlet_junit.calculator.calculation;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;

@Tag("calculator")
public class MultiplicationTest {

    @ParameterizedTest
    @CsvSource(value = {"2.0, 3.0, 6.0", "-4.1, -2.2, 9.02", "0.0, 3.7, 0.0"})
    public void testMultiplication(double firstNumber, double secondNumber, double expectedResult) {
        assertEquals("Multiplication is incorerct for values: " + firstNumber + " + " + secondNumber,
                expectedResult, ICalculator.multiply(firstNumber, secondNumber), 0.0);
    }
}