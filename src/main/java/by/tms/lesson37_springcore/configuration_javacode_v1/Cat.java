package by.tms.lesson37_springcore.configuration_javacode_v1;

import by.tms.lesson37_springcore.configuration_annotation.Pet;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("catBean")
@Scope("singleton")
public class Cat implements Pet {

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
}
