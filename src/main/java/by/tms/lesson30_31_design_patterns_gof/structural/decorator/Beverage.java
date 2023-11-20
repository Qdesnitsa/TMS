package by.tms.lesson30_31_design_patterns_gof.structural.decorator;

public abstract class Beverage {
    protected String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
