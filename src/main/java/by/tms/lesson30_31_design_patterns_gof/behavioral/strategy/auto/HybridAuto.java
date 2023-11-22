package by.tms.lesson30_31_design_patterns_gof.behavioral.strategy.auto;

import by.tms.lesson30_31_design_patterns_gof.behavioral.strategy.HybridFillStrategy;

public class HybridAuto extends Auto {
    public HybridAuto() {
        this.fillStrategy = new HybridFillStrategy();
    }
}
