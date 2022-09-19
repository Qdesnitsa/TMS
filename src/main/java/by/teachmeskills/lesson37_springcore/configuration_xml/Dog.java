package by.teachmeskills.lesson37_springcore.configuration_xml;

public class Dog implements Pet {
    public Dog() {
        System.out.println("Dog bean is created");
    }
    @Override
    public void say() {
        System.out.println("Bow-Wow");
    }
}
