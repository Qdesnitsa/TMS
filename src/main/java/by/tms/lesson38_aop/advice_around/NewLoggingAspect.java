package by.tms.lesson38_aop.advice_around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {
    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: Attempt to return book to the library");
        //long begin = System.currentTimeMillis();
        Object targetMethodResult = null;
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("aroundReturnBookLoggingAdvice" + e);
            //targetMethodResult = "Unknown bookName";
            throw e;
        }
        //long end = System.currentTimeMillis();
        System.out.println("aroundReturnBookLoggingAdvice: Book is returned to the library successfully");
        //System.out.println("aroundReturnBookLoggingAdvice: method returnBook execution took " + (end - begin) + " milliseconds.");
        return  targetMethodResult;
    }
}
