package by.teachmeskills.lesson37_springcore.configuration_xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainScopeSingleton {
    public static void main(String[] args) {

//scope по умолчанию - singleton, создаст bean согласно конфиг файлу, даже если мы это не запрашиваем напрямую через getBean
//singleton подходит для stateless объектов
//ЖЦ bean начинается с чтения Spring Container-а конфиг файла
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring_introduction/applicationContextScope.xml");

//Bean является общим для всех, кто запросит его у Spring Container
        Cat myCat = context.getBean("myPet", Cat.class);
        Cat yourCat = context.getBean("myPet", Cat.class);
        myCat.setName("Tom");
        yourCat.setName("Belka");
        System.out.println("the same object: " + (myCat==yourCat));
        System.out.println(myCat);
        System.out.println(yourCat);
        System.out.println(myCat.getName());
        System.out.println(yourCat.getName());

//Чтение из нескольких конфигурационных файлов
//        ClassPathXmlApplicationContext context
//                = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContextScope.xml");

        context.close();
    }
}
