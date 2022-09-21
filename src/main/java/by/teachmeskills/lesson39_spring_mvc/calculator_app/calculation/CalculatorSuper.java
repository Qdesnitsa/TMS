package by.teachmeskills.lesson38_aop.calculator_app.calculation;

import by.teachmeskills.lesson38_aop.calculator_app.entity.Calculator;
import by.teachmeskills.lesson38_aop.calculator_app.calculation.exception.DivisionByZeroException;
import by.teachmeskills.lesson38_aop.calculator_app.util.output.OutputConsole;
import by.teachmeskills.lesson38_aop.calculator_app.util.validator.ParserOfUserStringInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Stack;

@Component
public class CalculatorSuper implements Calculable {

    private Stack<Double> numbers = new Stack<>();

    private Stack<String> operators = new Stack<>();
    private String input;
    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";
    @Autowired
    private ParserOfUserStringInput parser;

    public void calculateResult(Calculator calc) {
        List<String> array;
        if (calc.getTypeOfInput() == 1) {
            input = calc.getExpression();
            array = parser.parserSixElements(input);
        } else
            array = parser.parserSixElements(calc);

        for (int i = 0; i < array.size(); ++i) {
            String element = array.get(i);

            try {
                double number = Double.parseDouble(element);
                numbers.push(number);
            } catch (NumberFormatException e) {
                if (element.equals(LEFT_PARENTHESIS)) {
                    operators.push(element);
                } else if (element.equals(RIGHT_PARENTHESIS)) {
                    while (!operators.peek().equals(LEFT_PARENTHESIS))
                        calculateOneOfFourOperation();
                    operators.pop();
                } else {
                    if (operators.empty()) {
                        operators.push(element);
                    } else {
                        Integer priority = PriorityOfOperator.obtainPriorityInt(element);
                        while (!operators.empty() &&
                                !(operators.peek()).equals(LEFT_PARENTHESIS) &&
                                !(operators.peek()).equals(RIGHT_PARENTHESIS) &&
                                priority <= PriorityOfOperator.obtainPriorityInt(operators.peek())) {
                            calculateOneOfFourOperation();
                        }
                        operators.push(element);
                    }
                }
            }
        }
        while (!operators.empty()) {
            calculateOneOfFourOperation();
        }
        calc.setResult(numbers.pop());
    }
    private void calculateOneOfFourOperation() {
        String operator = operators.pop();
        Double b = numbers.pop();
        Double a = numbers.pop();
        Double result = null;
        switch (operator) {
            case "+":
                result = Calculable.sum(a, b);
                break;
            case "-":
                result = Calculable.diff(a, b);
                break;
            case "*":
                result = Calculable.multiply(a, b);
                break;
            case "/":
                try {
                    result = Calculable.divide(a, b);
                } catch (DivisionByZeroException e) {
                    OutputConsole.printResultingMsg(String.valueOf(e));
                }
        }
        numbers.push(result);
    }
}

