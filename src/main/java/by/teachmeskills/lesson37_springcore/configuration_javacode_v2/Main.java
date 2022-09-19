package by.teachmeskills.lesson37_springcore.configuration_javacode_v2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
//        Pet cat = context.getBean("catBean", Pet.class);
//        Pet mycat = context.getBean("catBean", Pet.class);
//        System.out.println(cat == mycat);
//        cat.say();
        Person person = context.getBean("personBean", Person.class);
        Person person2 = context.getBean("personBean", Person.class);
        System.out.println(person2 == person);
        person.callYourPet();
        System.out.println(person.getAge());
        System.out.println(person.getSurname());
        System.out.println(person);

        context.close();
    }
}
