package by.tms.lesson30_31_design_patterns_gof.behavioral.template_method;

public class Main {
    public static void main(String[] args) {
        TeaWithHook teaWithHook = new TeaWithHook();
        CoffeeWithHook coffeeWithHook = new CoffeeWithHook();

        System.out.println("\nMaking Tea...");
        teaWithHook.prepareRecipe();

        System.out.println("\nMaking Coffee...");
        coffeeWithHook.prepareRecipe();
    }
}
