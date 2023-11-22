package by.tms.lesson30_31_design_patterns_gof.behavioral.strategy;

public class HybridFillStrategy implements FillStrategy {
    @Override
    public void fill() {
        System.out.println("Fill up with fuel or electricity!");
    }
}
