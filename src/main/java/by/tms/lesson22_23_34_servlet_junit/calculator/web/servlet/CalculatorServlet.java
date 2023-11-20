package by.tms.lesson22_23_34_servlet_junit.calculator.web.servlet;

import by.tms.lesson22_23_34_servlet_junit.calculator.entity.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/calculator", loadOnStartup = 1, name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    public static final String PARAMETER_EXPRESSION = "expression";
    public static final String ATTRIBUTE_MESSAGE = "message";
    public static final String ATTRIBUTE_RESULT_DOUBLE = "result_double";
    public static final String ATTRIBUTE_RESULT_STRING = "result_string";
    public static final String JSP_PATH_CALC = "/pages/calc.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(JSP_PATH_CALC).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Calculator dataFromPage = new Calculator(req.getParameter(PARAMETER_EXPRESSION));
        double resultDouble = 0;
        try {
            resultDouble = dataFromPage.getResult();
        } catch (RuntimeException e) {
            req.setAttribute(ATTRIBUTE_MESSAGE, e.getMessage());
        }

        String resultString = dataFromPage.toString();
        req.setAttribute(ATTRIBUTE_RESULT_DOUBLE, resultDouble);
        req.setAttribute(ATTRIBUTE_RESULT_STRING, resultString);
        getServletContext().getRequestDispatcher(JSP_PATH_CALC).forward(req, resp);
    }
}
