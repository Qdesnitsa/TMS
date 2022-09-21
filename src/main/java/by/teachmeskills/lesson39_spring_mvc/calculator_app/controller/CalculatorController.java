package by.teachmeskills.lesson39_spring_mvc.calculator_app.controller;

import by.teachmeskills.lesson39_spring_mvc.calculator_app.entity.Calculator;
import by.teachmeskills.lesson39_spring_mvc.calculator_app.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CalculatorController {
    @Autowired
    private UserStorage userStorage;
    @Autowired
    private Calculator calculator;
    private String userName;
    @GetMapping("/")
    public String getInfoForAll(Authentication authentication, Model model) {
        userName = authentication.getName();
        model.addAttribute("username", userName);
        return "calc";
    }

    @PostMapping("/calculator")
    public String postInfoForAll(Model model, HttpServletRequest request) {
        String expression = request.getParameter("expression");
        //userStorage.addToList("alena", expression);
        //List<String> expressions = userStorage.getList("alena");
        List<String> expressions = new ArrayList<>() ;
        expressions.add("2+2");
        expressions.add("22+22");
        expressions.add("222+222");
        model.addAttribute("username", userName);
        model.addAttribute("expressions",expressions);
        model.addAttribute("expression",expression);
        calculator = new Calculator(expression);
        double resultDouble = 0;
        try {
            resultDouble = calculator.getResult();
        } catch (RuntimeException e) {
            System.out.println("y");
        }
        String resultString = calculator.toString();
        model.addAttribute("result_double", 22);
        model.addAttribute("result_string", resultString);
        return "calc";
    }
}
