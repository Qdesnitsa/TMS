package by.teachmeskills.lesson22_23_34_servlet_junit.calculator.util;

import by.tms.lesson22_23_34_servlet_junit.calculator.util.ValidInput;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;

@Tag("utils")
public class CountBracketsTest {
    @ParameterizedTest
    @CsvSource(value = {"(,(9+99)*9,1", "*,(9+99)*9-8*8,2", "/,(9+99)*9-8*8,0"})
    public void testQuantityOfTargetElement(char targetElement, String input, int result) {
        assertEquals("Wrong result for value: " + input, result,
                ValidInput.countBrackets(targetElement, input));
    }
}