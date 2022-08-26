package by.teachmeskills.lesson30_31_design_patterns_gof.structural.adapter.duck_impl;

import by.teachmeskills.lesson30_31_design_patterns_gof.structural.adapter.Duck;
import by.teachmeskills.lesson30_31_design_patterns_gof.structural.adapter.Turkey;

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
