package by.teachmeskills.lesson39_spring_mvc.calculator_app.springconfig.aspect_config;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcut {
    @Pointcut("execution(* by.teachmeskills.lesson39_spring_mvc.calculator_app.*.*.*(..))")
    public void allMethods() {}

    @Pointcut("execution(* by.teachmeskills.lesson39_spring_mvc.calculator_app.util.validator.ParserOfUserStringInput.*(..))")
    public void parseMethods() {}
}
