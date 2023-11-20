package by.tms.lesson38_aop.pointcut_declaration_combination.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(20)
public class SecurityAspect {
//    @Before("by.teachmeskills.lesson38_aop.pointcut_declaration_combination.aspect.MyPointcut.allGetMethods()")
//    public void beforeGetSecurityAdvice() {
//        System.out.println("beforeGetSecurityAdvice: Check security permission on getting book/magazine");
//    }

    @Before("by.tms.lesson38_aop.pointcut_declaration_combination.aspect.MyPointcut.allAddMethods()")
    public void beforeAddSecurityAdvice() {
        System.out.println("beforeAddSecurityAdvice: Check security permission on getting book/magazine");
        System.out.println("---------------------------------------------------");
    }
}
