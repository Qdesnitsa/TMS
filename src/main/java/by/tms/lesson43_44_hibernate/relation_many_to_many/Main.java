package by.tms.lesson43_44_hibernate.relation_many_to_many;

import by.tms.lesson43_44_hibernate.relation_many_to_many.entity.Child;
import by.tms.lesson43_44_hibernate.relation_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
//            Section section1 = new Section("Football");
//            Child child1 = new Child("Tom", 5);
//            Child child2 = new Child("Bob", 6);
//            Child child3 = new Child("Samanta", 7);
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);

//            Section section1 = new Section("Volleyball");
//            Section section2 = new Section("Chess");
//            Section section3 = new Section("Math");
//            Child child = new Child("Garry", 10);
//            child.addSectionToChild(section1);
//            child.addSectionToChild(section2);
//            child.addSectionToChild(section3);
//            session.beginTransaction();
//            session.save(section1);
//            session.save(child);
//            Section section = session.get(Section.class, 1);
//            Child child = session.get(Child.class, 4);
//            System.out.println(section);
//            System.out.println(section.getChildren());
//            System.out.println("=================================================");
//            System.out.println(child);
//            System.out.println(child.getSections());
//            session.getTransaction().commit();

// Если заменить Cascade.ALL на перечисление конкретных типов каскада, то save изменить на persist из другой библиотеки - hibernate
//            Section section1 = new Section("Dance");
//            Child child1 = new Child("Taras", 9);
//            Child child2 = new Child("Joe", 11);
//            Child child3 = new Child("Donald", 11);
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);

            session.beginTransaction();
            Section section = session.get(Section.class,7);
//            session.persist(section1);
            session.delete(section);
            session.getTransaction().commit();

        }
        finally {
            session.close();
            factory.close();
        }
    }
}
