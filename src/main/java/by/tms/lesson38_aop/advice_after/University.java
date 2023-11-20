package by.tms.lesson38_aop.advice_after;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudents() {
        Student st1 = new Student("Tom Tomson", 4, 8.0);
        Student st2 = new Student("Bob Bobby", 2, 7.5);
        Student st3 = new Student("Jack Jackson", 3, 9.1);
        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

//    public List<Student> getStudents() {
//        System.out.println("Info from method getStudents(): " + students);
//        return students;
//    }

    public List<Student> getStudents() {
        System.out.println("Start getStudents()");
//Exception expected
        //System.out.println(students.get(3));
        System.out.println("Info from method getStudents(): " + students);
        return students;
    }
}
