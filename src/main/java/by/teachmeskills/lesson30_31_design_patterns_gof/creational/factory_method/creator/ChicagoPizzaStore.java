package by.teachmeskills.lesson30_31_design_patterns_gof.creational.factory_method.creator;

import by.teachmeskills.lesson30_31_design_patterns_gof.creational.factory_method.product.ChicagoStyleCheesePizza;
import by.teachmeskills.lesson30_31_design_patterns_gof.creational.factory_method.product.ChicagoStyleVeggiePizza;
import by.teachmeskills.lesson30_31_design_patterns_gof.creational.factory_method.product.NYStyleVeggiePizza;
import by.teachmeskills.lesson30_31_design_patterns_gof.creational.factory_method.product.Pizza;

public class ChicagoPizzaStore extends PizzaStore {
    public Pizza createPizza(String item) {
        if (item.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else if (item.equals("veggie")) {
            return new ChicagoStyleVeggiePizza();
        } else {
            return null;
        }
    }
}
