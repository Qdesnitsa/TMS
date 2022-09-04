package by.teachmeskills.lesson30_31_design_patterns_gof.creational.factory_method.creator;

import by.teachmeskills.lesson30_31_design_patterns_gof.creational.factory_method.product.NYStyleCheesePizza;
import by.teachmeskills.lesson30_31_design_patterns_gof.creational.factory_method.product.NYStyleVeggiePizza;
import by.teachmeskills.lesson30_31_design_patterns_gof.creational.factory_method.product.Pizza;

public class NYPizzaStore extends PizzaStore {
    public Pizza createPizza(String item) {
        if (item.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else if (item.equals("veggie")) {
            return new NYStyleVeggiePizza();
        } else {
            return null;
        }
    }
}
