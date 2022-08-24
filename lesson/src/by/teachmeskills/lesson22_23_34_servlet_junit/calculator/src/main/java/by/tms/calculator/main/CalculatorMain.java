package by.tms.calculator.main;

import by.tms.calculator.entity.Calculator;
import by.tms.calculator.output.OutputConsole;

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
