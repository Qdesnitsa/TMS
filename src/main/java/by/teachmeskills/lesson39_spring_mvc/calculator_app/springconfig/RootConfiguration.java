package by.teachmeskills.lesson39_spring_mvc.calculator_app.springconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("by.teachmeskills.lesson39_spring_mvc.calculator_app")
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class RootConfiguration {
}
