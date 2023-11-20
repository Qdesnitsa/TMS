package by.tms.lesson30_31_design_patterns_gof.structural.decorator.beverage;

import by.tms.lesson30_31_design_patterns_gof.structural.decorator.Beverage;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    @Override
    public double cost() {
        return 1.09;
    }
}
