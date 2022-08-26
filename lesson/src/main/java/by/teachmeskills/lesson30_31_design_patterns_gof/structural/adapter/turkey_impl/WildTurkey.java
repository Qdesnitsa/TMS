package by.teachmeskills.lesson30_31_design_patterns_gof.structural.adapter.turkey_impl;

import by.teachmeskills.lesson30_31_design_patterns_gof.structural.adapter.Turkey;

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
