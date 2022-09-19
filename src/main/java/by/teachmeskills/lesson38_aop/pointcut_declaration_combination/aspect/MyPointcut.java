package by.teachmeskills.lesson38_aop.pointcut_declaration_combination.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcut {
//    @Pointcut("execution(* get*())")
//    public void allGetMethods() {}

    @Pointcut("execution(* add*(..))")
    public void allAddMethods() {}
}
