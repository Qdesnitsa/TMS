package by.teachmeskills.lesson30_31_design_patterns_gof.adapter.duck_impl;

import by.teachmeskills.lesson30_31_design_patterns_gof.adapter.Duck;

public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
