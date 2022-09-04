package by.teachmeskills.lesson22_23_34_servlet_junit.calculator.calculation;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;

@Tag("calculator")
public class AdditionTest {

    @ParameterizedTest
    @CsvSource(value = {"2.3, 3.3, 5.6", "-1.0, 4.0, 3.0", "0.0, 10.1, 10.1"})
    public void testAddition(double firstNumber, double secondNumber, double expectedResult) {
        assertEquals("Addition is incorrect for values: " + firstNumber + " + " + secondNumber,
                expectedResult, ICalculator.sum(firstNumber, secondNumber), 0.0);
    }
}
