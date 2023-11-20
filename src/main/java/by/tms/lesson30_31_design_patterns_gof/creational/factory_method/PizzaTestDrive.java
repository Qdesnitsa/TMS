package by.tms.lesson30_31_design_patterns_gof.creational.factory_method;

import by.tms.lesson30_31_design_patterns_gof.creational.factory_method.creator.*;
import by.tms.lesson30_31_design_patterns_gof.creational.factory_method.product.Pizza;

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
}
