package by.tms.lesson30_31_design_patterns_gof.structural.adapter.duck_turkey_impl;

import by.tms.lesson30_31_design_patterns_gof.structural.adapter.Turkey;

public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}
