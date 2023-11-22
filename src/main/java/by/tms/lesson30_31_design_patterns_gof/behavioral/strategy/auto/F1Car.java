package by.tms.lesson30_31_design_patterns_gof.behavioral.strategy.auto;

import by.tms.lesson30_31_design_patterns_gof.behavioral.strategy.F1PitstopStrategy;

public class F1Car extends Auto {
    public F1Car() {
        this.fillStrategy = new F1PitstopStrategy();
    }
}
