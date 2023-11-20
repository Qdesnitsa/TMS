package by.tms.lesson30_31_design_patterns_gof.structural.decorator.beverage;

import by.tms.lesson30_31_design_patterns_gof.structural.decorator.Beverage;

public class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
