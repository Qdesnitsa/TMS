package by.teachmeskills.lesson37_springcore.configuration_javacode_v2;

import by.teachmeskills.lesson37_springcore.configuration_javacode_v2.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("catBean")
//@Scope("singleton")
public class Cat implements Pet {
    @Autowired
    private String city;

    public Cat() {
        System.out.println("Cat bean is created");
    }
    @Override
    public void say() {
        System.out.println("Meow-Meow");
    }
//    @PostConstruct
//    public void init() {
//        System.out.println("Class Cat: init-method");
//    }
//    @PreDestroy
//    public void destroy() {
//        System.out.println("Class Cat: destroy-method");
//    }


    @Override
    public String toString() {
        return "Cat{" +
                "city='" + city + '\'' +
                '}';
    }
}
