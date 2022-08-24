package by.tms.calculator.web.servlet;

import by.tms.calculator.entity.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/calculator", loadOnStartup = 1, name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Calculator dataFromPage = new Calculator(req.getParameter("expression"));
		double resultDouble = 0;
		try {
			resultDouble = dataFromPage.getResult();
		} catch (RuntimeException e) {
			req.setAttribute("message", e.getMessage());
		}

		String resultString = dataFromPage.toString();
		req.setAttribute("result_double", resultDouble);
		req.setAttribute("result_string", resultString);
		getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
	}
}
