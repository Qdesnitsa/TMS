package by.tms.lesson30_31_design_patterns_gof.structural.adapter.adapter;

import by.tms.lesson30_31_design_patterns_gof.structural.adapter.*;

public class TurkeyAdapter implements Duck {
    Turkey turkey;
    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }
    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
