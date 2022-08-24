package by.teachmeskills.lesson30_31_design_patterns_gof.abstract_factory.impl_factory;

import by.teachmeskills.lesson30_31_design_patterns_gof.abstract_factory.*;
import by.teachmeskills.lesson30_31_design_patterns_gof.abstract_factory.impl_coupe.ToyotaCoupe;
import by.teachmeskills.lesson30_31_design_patterns_gof.abstract_factory.impl_sedan.ToyotaSedan;

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
