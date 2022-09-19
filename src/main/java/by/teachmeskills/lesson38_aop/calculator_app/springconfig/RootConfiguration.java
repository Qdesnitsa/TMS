package by.teachmeskills.lesson38_aop.calculator_app.springconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("by.teachmeskills.lesson38_aop.calculator_app")
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class RootConfiguration {
}
