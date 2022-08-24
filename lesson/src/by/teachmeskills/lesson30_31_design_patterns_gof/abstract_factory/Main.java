package by.teachmeskills.lesson30_31_design_patterns_gof.abstract_factory;

import by.teachmeskills.lesson30_31_design_patterns_gof.abstract_factory.impl_factory.FordFactory;
import by.teachmeskills.lesson30_31_design_patterns_gof.abstract_factory.impl_factory.ToyotaFactory;

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
