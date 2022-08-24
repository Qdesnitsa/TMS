package by.teachmeskills.lesson30_31_design_patterns_gof.decorator.beverage;

import by.teachmeskills.lesson30_31_design_patterns_gof.decorator.Beverage;

public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
