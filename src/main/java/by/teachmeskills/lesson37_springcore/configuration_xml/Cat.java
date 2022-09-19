package by.teachmeskills.lesson37_springcore.configuration_xml;

public class Cat implements Pet {
    String name;
    public Cat() {
        System.out.println("Cat bean is created");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void say() {
        System.out.println("Meow-Meow");
    }

    public void init() {
        System.out.println("Class Cat: init-method");
    }

    public void destroy() {
        System.out.println("Class Cat: destroy-method");
    }
}
