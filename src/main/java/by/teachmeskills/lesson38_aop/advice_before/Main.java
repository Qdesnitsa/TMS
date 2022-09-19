package by.teachmeskills.lesson38_aop.advice_before;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        uniLibrary.getBook();
        uniLibrary.returnBook();
        uniLibrary.getMagazine(20);
        uniLibrary.getMagazine("Winter in Prostokvashino", 10);
        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        schoolLibrary.getBook();
        uniLibrary.getBook("Little Prince");

        Book book = context.getBean("book", Book.class);
        uniLibrary.getBook(book);
        context.close();
    }
}
