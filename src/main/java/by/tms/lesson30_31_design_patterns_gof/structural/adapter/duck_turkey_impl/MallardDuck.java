package by.tms.lesson30_31_design_patterns_gof.structural.adapter.duck_turkey_impl;

import by.tms.lesson30_31_design_patterns_gof.structural.adapter.Duck;

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
