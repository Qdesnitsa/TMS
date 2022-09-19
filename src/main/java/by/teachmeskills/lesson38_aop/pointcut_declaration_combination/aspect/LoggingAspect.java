package by.teachmeskills.lesson38_aop.pointcut_declaration_combination.aspect;

import by.teachmeskills.lesson38_aop.pointcut_declaration_combination.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
//@Order(-5)
@Order(10)
public class LoggingAspect {
//    @Pointcut("execution(* by.teachmeskills.lesson38_aop.pointcut_declaration_combination.UniLibrary.*(..))")
//    private void allMethodsFromUniLibrary() {
//    }
//
//    @Pointcut("execution(public void by.teachmeskills.lesson38_aop.pointcut_declaration_combination.UniLibrary.returnMagazine())")
//    private void returnMagazineFromUniLibrary() {
//    }
//
//    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
//    private void allMethodsExceptReturnMagazineFromUniLibrary() {
//    }
//
//    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
//    public void beforeAllMethodsExceptReturnMagazineAdvice() {
//        System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: Log #10");
//    }

//---------------------------------------------------------------------------------
//    @Pointcut("execution(* by.teachmeskills.lesson38_aop.pointcut_declaration_combination.UniLibrary.get*())")
//    private void allGetMethodsFromUniLibrary(){}
//
//    @Pointcut("execution(* by.teachmeskills.lesson38_aop.pointcut_declaration_combination.UniLibrary.return*())")
//    private void allReturnMethodsFromUniLibrary(){}
//
//    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
//    private void allGetAndReturnMethodsFromUniLibrary(){}
//
//    @Before("allGetMethodsFromUniLibrary()")
//    public void beforeGetLoggingAdvice() {
//        System.out.println("beforeGetLoggingAdvice: writing Log #1");
//    }
//
//    @Before("allReturnMethodsFromUniLibrary()")
//    public void beforeReturnLoggingAdvice() {
//        System.out.println("beforeReturnLoggingAdvice: writing Log #2");
//    }
//
//    @Before("allGetAndReturnMethodsFromUniLibrary()")
//    public void beforeGetAndReturnLoggingAdvice(){
//        System.out.println("beforeGetAndReturnLoggingAdvice: writing Log #3");
//    }

//---------------------------------------------------------------------------------

//@Pointcut("execution(* by.teachmeskills.lesson38_aop.pointcut_declaration.UniLibrary.*(..))") - любой метод класса

//    @Before("by.teachmeskills.lesson38_aop.pointcut_declaration_combination.aspect.MyPointcut.allGetMethods()")
//    public void beforeGetLoggingAdvice() {
//        System.out.println("beforeGetLoggingAdvice: Attempt to get a book/magazine");
//    }

    @Before("by.teachmeskills.lesson38_aop.pointcut_declaration_combination.aspect.MyPointcut.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod() = " + methodSignature.getMethod());
        System.out.println("methodSignature.getName() = " + methodSignature.getName());
        System.out.println("methodSignature.getReturnType() = " + methodSignature.getReturnType());

        if (methodSignature.getName().equals("addBook")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object obj : arguments) {
                if (obj instanceof Book) {
                    Book myBook = (Book) obj;
                    System.out.println(myBook);
                } else if (obj instanceof String) {
                    System.out.println(obj);
                }
            }
        }

        System.out.println("beforeAddLoggingAdvice: Attempt to add a book/magazine");
        System.out.println("---------------------------------------------------");
    }
}
