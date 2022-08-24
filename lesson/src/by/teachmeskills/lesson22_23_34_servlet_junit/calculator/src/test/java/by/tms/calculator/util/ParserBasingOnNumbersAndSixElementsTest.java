package by.tms.calculator.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("utils")
public class ParserBasingOnNumbersAndSixElementsTest {
    private List<String> elements;
    private ParserOfUserStringInput parser;

    @BeforeEach
    public void initParser() {
        parser = new ParserOfUserStringInput();
    }

    @Test
    public void testHasParsedByNumbersAndOperators() {
        elements = parser.parserSixElements("(3+6,8)/9+1");
        assertThat(elements)
                .hasSize(9)
                .isEqualTo(Arrays.asList("(", "3", "+", "6.8", ")", "/", "9", "+", "1"));
    }
}
