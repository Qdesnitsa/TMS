package by.tms.lesson37_springcore.configuration_xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainScopePrototype {
    public static void main(String[] args) {

//Bean создаётся только после обращения к Spring Container-у с помощью метода getBean
//Для каждого такого обращения создаётся новый bean в Spring Container-е
//Подходит для stateful объектов
//init-method вызывается для каждого новосозданного bean
//destroy-method для таких бинов не вызывется, нужно самостоятельно писать код освобождения ресурсов
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring_introduction/applicationContextScope.xml");
        Cat myCat = context.getBean("myPet", Cat.class);
        Cat yourCat = context.getBean("myPet", Cat.class);
        myCat.setName("Tom");
        yourCat.setName("Belka");
        System.out.println("the same object: " + (myCat==yourCat));
        System.out.println(myCat);
        System.out.println(yourCat);
        System.out.println(myCat.getName());
        System.out.println(yourCat.getName());


        context.close();
    }
}
