package by.tms.lesson30_31_design_patterns_gof.structural.decorator.condiment;

import by.tms.lesson30_31_design_patterns_gof.structural.decorator.*;

public class Whip extends CondimentDecorator {
    private Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return .25 + beverage.cost();
    }
}
