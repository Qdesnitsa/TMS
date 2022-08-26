package by.teachmeskills.lesson30_31_design_patterns_gof.creational.abstract_factory.impl_factory;

import by.teachmeskills.lesson30_31_design_patterns_gof.creational.abstract_factory.*;
import by.teachmeskills.lesson30_31_design_patterns_gof.creational.abstract_factory.impl_coupe.FordCoupe;
import by.teachmeskills.lesson30_31_design_patterns_gof.creational.abstract_factory.impl_sedan.FordSedan;

public class FordFactory implements CarsFactory {
    @Override
    public Sedan createSedan() {
        return new FordSedan();
    }

    @Override
    public Coupe createCoupe() {
        return new FordCoupe();
    }
}
