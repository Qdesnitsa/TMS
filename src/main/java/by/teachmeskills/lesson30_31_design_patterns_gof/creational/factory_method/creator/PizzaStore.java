package by.teachmeskills.lesson30_31_design_patterns_gof.creational.factory_method.creator;

import by.teachmeskills.lesson30_31_design_patterns_gof.creational.factory_method.product.Pizza;

//Creator содержит реализации всех методов, выполняющих операции с продуктами, кроме фабричного метода.
public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

//factoryMethod() - фабричный метод, позволяет субклассам выбрать тип создаваемого экземпляра.
//Класс-создатель не обладает информацией о фактическом типе создаваемых продуктов (определяется типом используемого субкласса).
    protected abstract Pizza createPizza(String type);
}
