package by.teachmeskills.lesson38_aop.advice_after;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UniversityLoggingAspect {
//    @Before("execution(* getStudents())")
//    public void beforeGetStudentsLoggingAdvice() {
//        System.out.println("beforeGetStudentsLoggingAdvice: logging getting the list of students before getStudents()");
//    }
//
//    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students")
//    public void afterReturningGetStudentsLoggingAdvice(JoinPoint joinPoint, List<Student> students) {
//        Student firstStudent = students.get(0);
//        String nameSurname = firstStudent.getNameSurname();
//        nameSurname = "Mr. " + nameSurname;
//        firstStudent.setNameSurname(nameSurname);
//        firstStudent.setAvgGrade(firstStudent.getAvgGrade() + 2);
//        System.out.println("afterReturningGetStudentsLoggingAdvice: logging getting the list of students after getStudents()");
//    }
//
//    @AfterThrowing(pointcut = "execution(* getStudents())"
//    , throwing = "exception")
//    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception) {
//        System.out.println("afterThrowingGetStudentsLoggingAdvice: logging throwing exception => " + exception);
//    }

    @After("execution(* getStudents())")
    public void afterGetStudentsLoggingAdvice(JoinPoint joinPoint) {
        System.out.println("afterGetStudentsLoggingAdvice: logging getting the list of students or exception after getStudents()");
    }
}
