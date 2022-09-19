package by.teachmeskills.lesson38_aop.advice_after;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("by.teachmeskills.lesson38_aop.advice_after")
@EnableAspectJAutoProxy
public class MyConfig {
}
