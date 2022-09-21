package by.teachmeskills.lesson39_spring_mvc.calculator_app.main;

import by.teachmeskills.lesson39_spring_mvc.calculator_app.entity.Calculator;
import by.teachmeskills.lesson39_spring_mvc.calculator_app.util.output.OutputConsole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Application {
    @Autowired
    private Calculator dataFromConsole;

    public  void run() {
        dataFromConsole.getResult();
        OutputConsole.printResultingMsg(dataFromConsole.toString());
    }

    @Override
    public String toString() {
        return dataFromConsole.toString();
    }
}
