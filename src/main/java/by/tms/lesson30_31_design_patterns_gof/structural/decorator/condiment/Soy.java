package by.tms.lesson30_31_design_patterns_gof.structural.decorator.condiment;

import by.tms.lesson30_31_design_patterns_gof.structural.decorator.*;

public class Soy extends CondimentDecorator {
    private Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return .30 + beverage.cost();
    }
}
