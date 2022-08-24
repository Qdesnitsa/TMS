package by.teachmeskills.lesson30_31_design_patterns_gof.decorator.condiment;

import by.teachmeskills.lesson30_31_design_patterns_gof.decorator.Beverage;
import by.teachmeskills.lesson30_31_design_patterns_gof.decorator.CondimentDecorator;

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
