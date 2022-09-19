package by.teachmeskills.lesson38_aop.pointcut_declaration_combination.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(30)
public class ExceptionHandlingAspect {
//    @Before("by.teachmeskills.lesson38_aop.pointcut_declaration_combination.aspect.MyPointcut.allGetMethods()")
//    public void beforeGetExceptionHandlingAdvice() {
//        System.out.println("beforeGetExceptionHandlingAdvice: catching/handling exception in an attempt to get a book/magazine");
//    }

    @Before("by.teachmeskills.lesson38_aop.pointcut_declaration_combination.aspect.MyPointcut.allAddMethods()")
    public void beforeAddExceptionHandlingAdvice() {
        System.out.println("beforeAddExceptionHandlingAdvice: catching/handling exception in an attempt to add a book/magazine");
        System.out.println("---------------------------------------------------");
    }
}
