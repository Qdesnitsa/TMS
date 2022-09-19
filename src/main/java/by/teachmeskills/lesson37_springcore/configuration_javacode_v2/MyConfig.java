package by.teachmeskills.lesson37_springcore.configuration_javacode_v2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:spring_introduction/myApp.properties")
//@ComponentScan("by.teachmeskills.lesson37_springcore.configuration_javacode_v1")
public class MyConfig {
    @Bean
    @Scope("singleton")
    public Pet catBean() {
        return new Cat();
    }

    @Bean
    public Person personBean() {
        return new Person(catBean());
    }

    @Bean
    public String city() {
        return "Minsk";
    }
}
