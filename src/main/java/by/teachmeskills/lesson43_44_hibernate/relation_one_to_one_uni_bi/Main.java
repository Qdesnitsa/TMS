package by.teachmeskills.lesson43_44_hibernate.relation_one_to_one_uni_bi;

import by.teachmeskills.lesson43_44_hibernate.relation_one_to_one_uni_bi.entity.Detail;
import by.teachmeskills.lesson43_44_hibernate.relation_one_to_one_uni_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;

        try {
//Uni-directional association
//            session = factory.getCurrentSession();
//            //Employee employee = new Employee("Tom","Tomson","IT",500);
//            //Employee employee = new Employee("Bob","Bobby","Sales",700);
//            //Detail detail = new Detail("Baku","123456789","tomson@tut.by");
//            //Detail detail = new Detail("Rio","987654321","bobby@tut.by");
//            //employee.setEmpDetail(detail);
//            session.beginTransaction();
//            //session.save(employee);
//            Employee employee = session.get(Employee.class,2);
//            session.delete(employee);
//            System.out.println(employee.getEmpDetail());
//            session.getTransaction().commit();
//            System.out.println("OK");

//Bi-directional association
            session = factory.getCurrentSession();
            Employee employee = new Employee("Sam","Sammy","HR",1500);
            Detail detail = new Detail("London","103456789","sammy@tut.by");
            employee.setEmpDetail(detail);
            detail.setEmployee(employee);
            session.beginTransaction();
            session.save(employee);
            //Employee employee = session.get(Employee.class,2);
            //session.delete(employee);
            System.out.println(employee.getEmpDetail());
            System.out.println(detail.getEmployee());
//            Detail detail2 = session.get(Detail.class,3);
//            System.out.println(detail2.getEmployee());
//            session.delete(detail);
            session.getTransaction().commit();
            System.out.println("OK");
        } finally {
            session.close();
            factory.close();
        }
    }
}
