package by.tms.lesson22_23_34_servlet_junit.calculator.main;

import by.tms.lesson22_23_34_servlet_junit.calculator.entity.Calculator;
import by.tms.lesson22_23_34_servlet_junit.calculator.output.OutputConsole;

public class CalculatorMain {

    public static void main(String[] args) {
        Calculator dataFromConsole = new Calculator();
        dataFromConsole.getResult();
        OutputConsole.printResultingMsg(dataFromConsole.toString());

        Calculator dataFromArgument = new Calculator("1,1+19.1-((3-2)+15)/1");
        dataFromArgument.getResult();
        OutputConsole.printResultingMsg(dataFromArgument.toString());
    }
}
