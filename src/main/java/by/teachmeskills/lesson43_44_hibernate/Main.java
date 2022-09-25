package by.teachmeskills.lesson43_44_hibernate;

import by.teachmeskills.lesson43_44_hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
//            Session session = factory.getCurrentSession();
//            Employee emp = new Employee("Elena", "Prekrasnaya", "IT", 1000000);
//            session.beginTransaction();
//            session.save(emp);
//            //session.getTransaction().commit();
//            int myId = emp.getId();
//            //session = factory.getCurrentSession();
//            //session.beginTransaction();
//            Employee employee = session.get(Employee.class,myId);
//            session.getTransaction().commit();
//            System.out.println(employee);

            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            List<Employee> emps = session.createQuery("FROM Employee")
//                            .getResultList();
            List<Employee> emps = session.createQuery("FROM Employee WHERE name = 'Tom' AND salary > 20000")
                    .getResultList();
            for (Employee e : emps) {
                System.out.println(e);
            }
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
