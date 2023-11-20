package by.tms.lesson38_aop.advice_around;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("by.teachmeskills.lesson38_aop.advice_around")
@EnableAspectJAutoProxy
public class MyConfig {
}
