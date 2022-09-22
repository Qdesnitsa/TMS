package by.teachmeskills.lesson39_spring_mvc.calculator_app.entity;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class User {
    private String name;
    private String password;
    private List<String> roles;
    private String expression;
    private List<String> expressions;

    public User() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<String> expressions) {
        this.expressions = expressions;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", expressions=" + expressions +
                '}';
    }
}
