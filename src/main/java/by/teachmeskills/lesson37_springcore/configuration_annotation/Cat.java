package by.teachmeskills.lesson37_springcore.configuration_annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("catBean")
@Scope("prototype")
public class Cat implements Pet {

    public Cat() {
        System.out.println("Cat bean is created");
    }
    @Override
    public void say() {
        System.out.println("Meow-Meow");
    }
    @PostConstruct
    public void init() {
        System.out.println("Class Cat: init-method");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("Class Cat: destroy-method");
    }
}
