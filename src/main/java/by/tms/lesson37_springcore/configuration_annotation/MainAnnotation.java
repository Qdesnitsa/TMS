package by.tms.lesson37_springcore.configuration_annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnnotation {
    public static void main(String[] args) {
//Spring сканирует в пакете классы @Component, по дефолту scope - Singleton => сразу создаёт bean
//Сканирует @Autowired (конструктор, сеттер, поле) и пытается внедрить зависимость - Есть ли подходящие beans по типу класса
//Если по типу ничего не находит или > 1 => Exception
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring_introduction/applicationContextAnnotation.xml");
        Person person = context.getBean("personBean",Person.class);
//        person.callYourPet();
//        System.out.println(person.getAge());
//        System.out.println(person.getSurname());

        Cat cat = context.getBean("catBean", Cat.class);
        Cat mycat = context.getBean("catBean", Cat.class);
        System.out.println(cat == mycat);
        mycat.say();
//        Cat myCat = context.getBean("catBean", Cat.class);
//        Cat myCat = context.getBean("cat", Cat.class);
//        myCat.say();
        context.close();
    }
}
