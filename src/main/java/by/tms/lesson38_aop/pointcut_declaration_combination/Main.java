package by.tms.lesson38_aop.pointcut_declaration_combination;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        Book book = context.getBean("book",Book.class);
        uniLibrary.getBook();
        //uniLibrary.returnMagazine();
        //uniLibrary.addBook();
        //uniLibrary.getMagazine();

        uniLibrary.addBook("Bob", book);
        uniLibrary.addMagazine();

        context.close();
    }
}
