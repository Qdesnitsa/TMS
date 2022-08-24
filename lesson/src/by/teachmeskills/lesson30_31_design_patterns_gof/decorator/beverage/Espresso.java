package by.teachmeskills.lesson30_31_design_patterns_gof.decorator.beverage;

import by.teachmeskills.lesson30_31_design_patterns_gof.decorator.Beverage;

public class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
