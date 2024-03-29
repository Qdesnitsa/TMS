//package by.teachmeskills.lesson50_spring_security.configuration;
//
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.UserBuilder;
//
//@EnableWebSecurity
//public class MySecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        auth.inMemoryAuthentication()
//                .withUser(userBuilder.username("tom")
//                        .password("tom")
//                        .roles("EMPLOYEE"))
//                .withUser(userBuilder.username("bob")
//                        .password("bob")
//                        .roles("HR"))
//                .withUser(userBuilder.username("sam")
//                        .password("sam")
//                        .roles("MANAGER", "HR"));
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests()
//                .antMatchers("/").hasAnyRole("EMPLOYEE","HR","MANAGER")
//                .antMatchers("/hr_info").hasRole("HR")
//                .antMatchers("/manager_info").hasRole("MANAGER")
//                .and().formLogin().permitAll();
//    }
//}
