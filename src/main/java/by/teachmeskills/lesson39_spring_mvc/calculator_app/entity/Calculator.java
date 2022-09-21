package by.teachmeskills.lesson38_aop.calculator_app.entity;

import by.teachmeskills.lesson38_aop.calculator_app.calculation.CalculatorSuper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Objects;

@Component
public class Calculator implements Serializable {
    private static final long serialVersionUID = -7456176617850911171L;
    private String expression;
    private double result;
    private int typeOfInput;

    @Autowired
    private CalculatorSuper calculatorCalculable;

    public Calculator() {
        this.typeOfInput = 0;
    }

    public Calculator(String expression) {
        this.expression = expression;
        this.typeOfInput = 1;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public double getResult() {
        try {
            calculatorCalculable.calculateResult(this);
        } catch (NullPointerException e) {
            expression += " = Error. ";
            return 0;
        }
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public int getTypeOfInput() {
        return typeOfInput;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Calculator that = (Calculator) o;
        return Double.compare(that.result, result) == 0 && typeOfInput == that.typeOfInput
                && Objects.equals(expression, that.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression, result, typeOfInput);
    }

    @Override
    public String toString() {
        if (expression.contains("Error")) {
            return expression + "Please check your input expression.";
        }
        DecimalFormat dF = new DecimalFormat("#.##");
        return expression +
                " = " + dF.format(result);
    }
}
