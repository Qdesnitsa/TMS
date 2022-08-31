package by.teachmeskills.lesson30_31_design_patterns_gof.structural.decorator.condiment;

import by.teachmeskills.lesson30_31_design_patterns_gof.structural.decorator.Beverage;
import by.teachmeskills.lesson30_31_design_patterns_gof.structural.decorator.CondimentDecorator;

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