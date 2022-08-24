package by.teachmeskills.lesson30_31_design_patterns_gof.decorator.beverage;

import by.teachmeskills.lesson30_31_design_patterns_gof.decorator.Beverage;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    @Override
    public double cost() {
        return 1.09;
    }
}
