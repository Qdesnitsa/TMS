package by.teachmeskills.lesson43_44_hibernate.relation_one_to_many_uni_bi;

import by.teachmeskills.lesson43_44_hibernate.relation_one_to_many_uni_bi.entity_bi.Department;
//import by.teachmeskills.lesson43_44_hibernate.relation_one_to_many_uni_bi.entity_uni.Department;
import by.teachmeskills.lesson43_44_hibernate.relation_one_to_many_uni_bi.entity_bi.Employee;
//import by.teachmeskills.lesson43_44_hibernate.relation_one_to_many_uni_bi.entity_uni.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;

        try {
// Bi-directional association
//            session = factory.getCurrentSession();
//            Department dep = new Department("IT", 300, 10000);
//            Employee emp1 = new Employee("Tom","Tomson",500);
//            Employee emp2 = new Employee("Bob","Bobby",1500);
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            session.beginTransaction();
//            session.save(dep);
//            session.getTransaction().commit();
//            System.out.println("OK");

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Department department = session.get(Department.class, 1);
//            System.out.println(department);
//            System.out.println(department.getEmps());
//            Employee employee = session.get(Employee.class,1);
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());
//            session.getTransaction().commit();
//            System.out.println("OK");

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class,1);
//            session.delete(employee); //удалятся все связанные записи с обоих таблиц
//            session.getTransaction().commit();
//            System.out.println("OK");

// Uni-directional association
//            session = factory.getCurrentSession();
//            Department dep = new Department("HR", 500, 8000);
//            Employee emp1 = new Employee("Jack","Daniels",1500);
//            Employee emp2 = new Employee("Mile","Mikky",1000);
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            session.beginTransaction();
//            session.save(dep);
//            Department department = session.get(Department.class,3);
//            System.out.println(department);
//            System.out.println(department.getEmps());
//            Employee employee = session.get(Employee.class,3);
//            department.getEmps().remove(employee);
//            session.delete(employee);
//            session.getTransaction().commit();
//            System.out.println("OK");

// Eager and lazy loading types
            //Eager type - hibernate performs only ony select query to DB and obtains all the associated data
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Get department");
            Department department = session.get(Department.class,1);
            System.out.println("Show departments");
            System.out.println(department);
            System.out.println("Show employees of department");
            System.out.println(department.getEmps());
            department.getEmps().get(0); // ALL employees will be loaded
            session.getTransaction().commit();
            //If Lazy type was set up - only department info would be got, after commit new request to get employees info is impossible
            System.out.println(department.getEmps());
            System.out.println("OK");

        } finally {
            session.close();
            factory.close();
        }
    }
}
