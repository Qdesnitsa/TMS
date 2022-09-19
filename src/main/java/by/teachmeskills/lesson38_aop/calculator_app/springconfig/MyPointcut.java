package by.teachmeskills.lesson38_aop.calculator_app.springconfig;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcut {
    @Pointcut("execution(* by.teachmeskills.lesson38_aop.calculator_app.*.*.*(..))")
    public void allMethods() {}

    @Pointcut("execution(* by.teachmeskills.lesson38_aop.calculator_app.util.validator.ParserOfUserStringInput.*(..))")
    public void parseMethods() {}
}
