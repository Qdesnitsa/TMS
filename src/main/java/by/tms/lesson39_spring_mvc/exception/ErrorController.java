//package by.teachmeskills.lesson39_spring_mvc.exception;
//
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class ErrorController {
//    @ExceptionHandler(Exception.class)
//    public String error(Exception e, Model model) {
//        model.addAttribute("message", e.getMessage());
//        return "error";
//    }
//}
