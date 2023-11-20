package by.tms.lesson38_aop.pointcut_declaration_combination;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("by.teachmeskills.lesson38_aop.pointcut_declaration_combination")
@EnableAspectJAutoProxy
public class MyConfig {
}
