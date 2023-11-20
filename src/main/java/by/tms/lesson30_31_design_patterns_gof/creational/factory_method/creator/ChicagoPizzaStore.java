package by.tms.lesson30_31_design_patterns_gof.creational.factory_method.creator;

import by.tms.lesson30_31_design_patterns_gof.creational.factory_method.product.*;

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
