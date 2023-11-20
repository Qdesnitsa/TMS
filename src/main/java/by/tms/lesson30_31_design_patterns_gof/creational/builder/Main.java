package by.tms.lesson30_31_design_patterns_gof.creational.builder;

public class Main {
    public static void main(String[] args) {
        User user = new User.UserBuilder()
                .name("Tom")
                .surname("Tommy")
                .password("12345")
                .id(0)
                .build();
        System.out.println(user.toString());
    }
}
