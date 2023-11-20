package by.tms.lesson30_31_design_patterns_gof.creational.abstract_factory.impl_factory;

import by.tms.lesson30_31_design_patterns_gof.creational.abstract_factory.*;
import by.tms.lesson30_31_design_patterns_gof.creational.abstract_factory.impl_coupe.ToyotaCoupe;
import by.tms.lesson30_31_design_patterns_gof.creational.abstract_factory.impl_sedan.ToyotaSedan;

public class ToyotaFactory implements CarsFactory {
    @Override
    public Sedan createSedan() {
        return new ToyotaSedan();
    }

    @Override
    public Coupe createCoupe() {
        return new ToyotaCoupe();
    }
}
