package by.teachmeskills.lesson38_aop.calculator_app.springconfig;

import by.teachmeskills.lesson38_aop.calculator_app.entity.Calculator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class ConsoleAspect {
    @Before("by.teachmeskills.lesson38_aop.calculator_app.springconfig.MyPointcut.parseMethods()")
    public void beforeCalculationResultAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Attempt to call method: " + methodSignature.getMethod());
    }

    @After("by.teachmeskills.lesson38_aop.calculator_app.springconfig.MyPointcut.parseMethods()")
    public void afterCalculationResultAdvice(JoinPoint joinPoint) {
        Object[] arguments = joinPoint.getArgs();
        for (Object obj : arguments) {
            if (obj instanceof Calculator) {
                Calculator calc = (Calculator) obj;
                System.out.println("TypeOfInput: " + calc.getTypeOfInput() + "; Your Expression " + calc.getExpression());
            } else {
                System.out.println(obj);
            }
        }
    }
}