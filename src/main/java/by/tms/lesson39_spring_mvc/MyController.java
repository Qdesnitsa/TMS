//package by.teachmeskills.lesson39_spring_mvc;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//
//@Controller
//@RequestMapping("/employee")
//public class MyController {
//    @RequestMapping("/")
//    public String showFirstView() {
//        return "first-view";
//    }
//
//    @RequestMapping("/askDetails")
//    public String askEmployeeDetails(Model model) {
////        Employee emp = new Employee();
////        emp.setName("Tom");
////        emp.setSurname("Tomson");
////        emp.setSalary(100500);
//        model.addAttribute("employee", new Employee());
//        return "ask-emp-details-view";
//    }
//
////    @RequestMapping("/showDetails")
////    public String showEmpDetails(HttpServletRequest request, Model model) {
////        String empName = request.getParameter("employeeName");
////        empName = "Mr./Ms. " + empName;
////        model.addAttribute("nameAttribute", empName);
////        model.addAttribute("description", " - current user");
////        return "show-emp-details-view";
////    }
//
////    @RequestMapping("/showDetails")
////    public String showEmpDetails(@RequestParam("employeeName") String empName, Model model) {
////        empName = "Mr./Ms. " + empName;
////        model.addAttribute("nameAttribute", empName);
////        model.addAttribute("description", " - current user");
////        return "show-emp-details-view";
////    }
//
//    @RequestMapping("/showDetails")
//    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp, BindingResult bindingResult) {
////        emp.setName("Mr./Ms. " + emp.getName());
////        emp.setSurname(emp.getSurname() + "!!!");
////        emp.setSalary(emp.getSalary()*100);
//
////     if (bindingResult.hasErrors()) {
////            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
////			for (FieldError fieldError : fieldErrors) {
////                model.addAttribute(fieldError.getField(), fieldError.getDefaultMessage());
////            }
////            return "calc";
////        } else {
////            return "calc";
////        }
//
//        if (bindingResult.hasErrors()) {
//            return "ask-emp-details-view";
//        } else {
//            return "show-emp-details-view";
//        }
//    }
//
//    @ExceptionHandler(Throwable.class)
//    public String error() {
//        return "error";
//    }
//}
