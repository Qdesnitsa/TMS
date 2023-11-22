package by.tms.lesson30_31_design_patterns_gof.behavioral.strategy.auto;

import by.tms.lesson30_31_design_patterns_gof.behavioral.strategy.StandartFillStrategy;

public class Sedan extends Auto {
    public Sedan() {
        this.fillStrategy = new StandartFillStrategy();
    }
}
