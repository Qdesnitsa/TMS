package by.teachmeskills.lesson43_44_hibernate.introduction;

import by.teachmeskills.lesson43_44_hibernate.introduction.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
//            List<Employee> emps = session.createQuery("FROM Employee WHERE name = 'Tom' AND salary > 20000")
//                    .getResultList();
//            for (Employee e : emps) {
//                System.out.println(e);
//            }
            //Employee emp = session.get(Employee.class,3);
            //emp.setSalary(15000);
            //session.createQuery("UPDATE Employee SET salary=25000 WHERE name='Tom'").executeUpdate();
            //session.delete(emp);
            session.createQuery("DELETE Employee WHERE name='Bob'").executeUpdate();
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
