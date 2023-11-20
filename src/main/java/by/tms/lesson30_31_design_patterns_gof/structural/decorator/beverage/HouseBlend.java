package by.tms.lesson30_31_design_patterns_gof.structural.decorator.beverage;

import by.tms.lesson30_31_design_patterns_gof.structural.decorator.Beverage;

public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
