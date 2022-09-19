package by.teachmeskills.lesson37_springcore.configuration_javacode_v2;

import by.teachmeskills.lesson37_springcore.configuration_javacode_v2.Pet;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Scope("singleton")
public class Dog implements Pet {
    public Dog() {
        System.out.println("Dog bean is created");
    }
    @Override
    public void say() {
        System.out.println("Bow-Wow");
    }
}
