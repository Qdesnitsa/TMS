package by.tms.lesson38_aop.advice_before;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {
    @Override
    public void getBook() {
        System.out.println("We take a book from UniLibrary");
    }

    public void getBook(String bookName) {
        System.out.println("We take a book from UniLibrary " + bookName);
    }

    public void getBook(Book book) {
        System.out.println("We take a book from UniLibrary " + book.getName());
    }

    public String returnBook() {
        System.out.println("We return a book to UniLibrary");
        return "OK";
    }

    public void getMagazine(int number) {
        System.out.println("We take a magazine from UniLibrary");
    }

    public void getMagazine(String name, int number) {
        System.out.println("We take a magazine " + name + " from UniLibrary, count " + number);
    }
}
