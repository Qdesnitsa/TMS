package by.teachmeskills.lesson30_31_design_patterns_gof.creational.factory_method;

import by.teachmeskills.lesson30_31_design_patterns_gof.creational.factory_method.creator.ChicagoPizzaStore;
import by.teachmeskills.lesson30_31_design_patterns_gof.creational.factory_method.creator.NYPizzaStore;
import by.teachmeskills.lesson30_31_design_patterns_gof.creational.factory_method.creator.PizzaStore;
import by.teachmeskills.lesson30_31_design_patterns_gof.creational.factory_method.product.Pizza;

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
