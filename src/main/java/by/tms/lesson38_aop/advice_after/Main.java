package by.tms.lesson38_aop.advice_after;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        University university = context.getBean("university", University.class);
        university.addStudents();
        List<Student> students = null;
        try {
            students = university.getStudents();
        } catch (Exception e) {
            System.out.println("Exception was caught" + e);
        }
        System.out.println(students);
        context.close();
    }
}
