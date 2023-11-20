package by.tms.lesson38_aop.advice_before;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstractLibrary {
    @Override
    public void getBook() {
        System.out.println("We take a book from SchoolLibrary");
    }
}
