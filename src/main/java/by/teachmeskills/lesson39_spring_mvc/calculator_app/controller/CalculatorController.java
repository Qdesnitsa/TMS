package by.teachmeskills.lesson39_spring_mvc.calculator_app.controller;

import by.teachmeskills.lesson39_spring_mvc.calculator_app.entity.Calculator;
import by.teachmeskills.lesson39_spring_mvc.calculator_app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CalculatorController {
    @Autowired
    private User user;
    @Autowired
    private Calculator calculator;
    private String userName;
    @RequestMapping("/")
    public String getInfoForAll(Authentication authentication, HttpSession session) {
        session.setAttribute("user", user);
        user.setName(authentication.getName());
        return "calc";
    }

    @RequestMapping("/calculator")
    public String postInfoForAll(@ModelAttribute("user") User user, Model model) {
        //userStorage.addToList("alena", expression);
        //List<String> expressions = userStorage.getList("alena");
        String expression1 = user.getExpression();
        user.setExpression("20+23");
        List<String> expressions = user.getExpressions();
        expressions.add("2+2");
        user.setExpressions(expressions);
        model.addAttribute("expression1",expression1);
        calculator = new Calculator();
        double resultDouble = 0;
        try {
            resultDouble = calculator.getResult();
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        String resultString = calculator.toString();
        model.addAttribute("result_double", 22);
        model.addAttribute("result_string", resultString);
        return "calc";
    }
}
