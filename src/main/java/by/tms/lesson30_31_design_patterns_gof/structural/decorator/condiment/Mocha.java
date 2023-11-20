package by.tms.lesson30_31_design_patterns_gof.structural.decorator.condiment;

import by.tms.lesson30_31_design_patterns_gof.structural.decorator.*;

public class Mocha extends CondimentDecorator {
    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}
