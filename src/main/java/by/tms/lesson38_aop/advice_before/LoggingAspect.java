package by.tms.lesson38_aop.advice_before;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
//В скобках - Pointcut (где, к чему должен выполниться сквозной код). Название метода - любое, но понятное. Придерживаться шаблона!
//Для любого метода getBook() вне зависимости от класса:
// @Before("execution(public void getBook())")

//Для конкретного метода в конкретном классе
//    @Before("execution(public void by.teachmeskills.lesson38_aop.advice_before.UniLibrary.getBook())")
//    public void beforeGetBookAdvice() {
//        System.out.println("beforeGetBookAdvice: Attempt to get a book");
//    }

//Соответствует методу с именем, начинающимся на "get" без параметров public void, где бы он ни находился
//execution(public void get*())
//    @Before("execution(public void get*())")
//    public void beforeGetBookAdvice() {
//        System.out.println("beforeGetBookAdvice: Attempt to get a book");
//    }

//@Before("execution(public void getBook(by.teachmeskills.lesson38_aop.advice_before.Book, ..))") - Первый параметр Book, далее - ноль и более параметров любого типа
    @Before("execution(public void getBook(by.tms.lesson38_aop.advice_before.Book))")
    public void beforeGetBookAdvice() {
        System.out.println("beforeGetBookAdvice: Attempt to get a book");
    }

//    @Before("execution(public void get*(String))")
//    public void beforeGetWithOneStringParameterBookAdvice() {
//        System.out.println("beforeGetBookAdvice with parameter: Attempt to get a book");
//    }

    @Before("execution(public void *(*))")
    public void beforeGetWithAnyOneParameterBookAdvice() {
        System.out.println("beforeGetBookAdvice with parameter: Attempt to get a book");
    }

    @Before("execution(public void *(..))")
    public void beforeGetWithAnyNumberOfParametersBookAdvice() {
        System.out.println("beforeGetBookAdvice with any number of parameters: Attempt to get a book");
    }

    @Before("execution(* returnBook())")
    public void beforeReturnBookAdvice() {
        System.out.println("beforeReturnBookAdvice: Attempt to return a book");
    }

//execution(* *()) - метод без параметров, с любыми месторасположением, access modifier, return type, name
}
