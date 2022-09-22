package by.teachmeskills.lesson39_spring_mvc.calculator_app.springconfig.security_config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("tom")
                        .password("tom")
                        .roles("ACCOUNTANT"))
                .withUser(userBuilder.username("bob")
                        .password("bob")
                        .roles("DEVELOPER"))
                .withUser(userBuilder.username("sam")
                        .password("sam")
                        .roles("DEVELOPER", "ACCOUNTANT"))
                .withUser(userBuilder.username("alena")
                        .password("alena")
                        .roles("CEO"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/", "/calculator").hasAnyRole("ACCOUNTANT", "DEVELOPER", "CEO")
                .antMatchers("/accountant_info").hasRole("ACCOUNTANT")
                .antMatchers("/developer_info").hasRole("DEVELOPER")
                .antMatchers("/ceo_info").hasRole("CEO")
                .and().formLogin().permitAll();
    }
}
