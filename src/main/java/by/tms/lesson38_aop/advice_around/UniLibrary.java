package by.tms.lesson38_aop.advice_around;

import by.tms.lesson38_aop.pointcut_declaration_combination.Book;
import org.springframework.stereotype.Component;

@Component
public class UniLibrary {

    public void addBook(String userName, Book book) {
        System.out.println("We add the book to the UniLibrary");
        System.out.println("---------------------------------------------------");
    }

    public void getBook() {
        System.out.println("We take the book from the UniLibrary");
        System.out.println("---------------------------------------------------");
    }

    public String returnBook() {
        int a = 10 / 0;
        System.out.println("We return the book to the UniLibrary");
        return "War and Peace";
    }

    public void addMagazine() {
        System.out.println("We add the magazine to the UniLibrary");
        System.out.println("---------------------------------------------------");
    }

    public void getMagazine() {
        System.out.println("We take the magazine from the UniLibrary");
        System.out.println("---------------------------------------------------");
    }

    public void returnMagazine() {
        System.out.println("We return the magazine to the UniLibrary");
        System.out.println("---------------------------------------------------");
    }
}
