package by.tms.lesson30_31_design_patterns_gof.creational.abstract_factory;

import by.tms.lesson30_31_design_patterns_gof.creational.abstract_factory.impl_factory.*;

public class Main {
    public static void main(String[] args) {
        CarsFactory factory;
        factory = new ToyotaFactory();
        factory.createSedan();
        factory.createCoupe();

        factory = new FordFactory();
        factory.createSedan();
        factory.createCoupe();
    }
}
