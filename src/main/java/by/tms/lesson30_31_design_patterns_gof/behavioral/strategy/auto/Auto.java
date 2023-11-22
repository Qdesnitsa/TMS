package by.tms.lesson30_31_design_patterns_gof.behavioral.strategy.auto;

import by.tms.lesson30_31_design_patterns_gof.behavioral.strategy.FillStrategy;

public class Auto {
    FillStrategy fillStrategy;

    public void fill() {
        fillStrategy.fill();
    }

    public void gas() {
        System.out.println("Burn up the road");
    }

    public void stop() {
        System.out.println("Braking the car!");
    }

    public void setFillStrategy(FillStrategy fillStrategy) {
        this.fillStrategy = fillStrategy;
    }
}
